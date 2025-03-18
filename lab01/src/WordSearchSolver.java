import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

/**
 * MainClass
 * It should have the ability to find a list of words
 */

public class WordSearchSolver {
    static int MAX_SIZE = 40;
    static char[][] lines;
    static List<String> search_words = new ArrayList<String>();
    static int width = -1;

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java WordSearchSolver <file>");
            System.exit(1);
        }

        verification(args[0]);

        int[][] result = new int[search_words.size()][4];

        // Reorder the words by length and get indexes to
        // save the result in previous order later
        Stream<Integer> indexstream = IntStream.range(0, search_words.size()).boxed();
        List<Integer> indexes = indexstream
                .sorted((a, b) -> search_words.get(b).length() - search_words.get(a).length())
                .toList();
        List<String> sortedWords = search_words.stream().sorted((a, b) -> b.length() - a.length()).toList();

        for (int i = 0; i < sortedWords.size(); i++) {
            String word = sortedWords.get(i);
            result[indexes.get(i)] = searchWord(word, lines, result);
            if (result[indexes.get(i)][0] == -1) {
                System.err.println("Word not found: " + word);
                System.exit(1);
            }
        }
        print_result(search_words, lines, result);
    }

    public static void verification(String file) {

        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
            for (int i = 0; i < width || width == -1; i++) {
                String line = scanner.nextLine();

                if (width == -1) {
                    width = line.length();
                    lines = new char[width][width];
                } else if (width > MAX_SIZE || line.length() < width) {
                    System.err.println("Invalid puzzle");
                    System.exit(1);
                } else if (checkString(line, width) == 0) {
                    System.err.println("Line doesn't meet the criteria");
                    System.exit(1);
                }

                lines[i] = line.toCharArray();
            }
            Pattern chars_regex = Pattern.compile("[a-zA-Z]+");
            String split_regex = ";|,| ";
            while (scanner.hasNextLine()) {
                String words_line = scanner.nextLine();
                String[] words = words_line.split(split_regex);
                for (String word : words) {
                    if (word.toUpperCase().equals(word) || !chars_regex.matcher(word).matches() || word.isEmpty()) {
                        System.err.println("Invalid puzzle");
                        System.exit(1);
                    }
                    search_words.add(word.toUpperCase());
                }
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file);
            System.exit(1);
        }
    }

    public static int checkString(String line, int width) {
        if (line.length() == width) {
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (!(Character.isUpperCase(c) && Character.isLetter(c))) {
                    return 0;
                }
            }
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Search word in the puzzle
     * 
     * @param word            the word to be searched
     * @param lines           list with all lines
     * @param previousResults list with all previous results
     * @return an array with 4 elements, the first two are the x and y coordinates
     *         of
     *         the first letter of the word, the third and fourth are the direction
     */
    public static int[] searchWord(String word, char[][] lines, int[][] previousResults) {
        int wordSize = word.length();
        int[] result = { -1, -1, -1, -1 };
        for (int y = 0; y < lines.length; y++) {
            for (int x = 0; x < lines[y].length; x++) {
                if (lines[y][x] == word.charAt(0)) {
                    // For each direction
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            // Skip the case where both dx and dy are 0
                            if (dx == 0 && dy == 0) {
                                continue;
                            }

                            int xWordLimit = dx * (wordSize - 1) + x;
                            int yWordLimit = dy * (wordSize - 1) + y;

                            // verify if the word is contained in another result
                            boolean contained = false;
                            for (int i = 0; i < previousResults.length; i++) {
                                if (Math.abs(previousResults[i][2]) == Math.abs(dx) && Math.abs(previousResults[i][3]) == Math.abs(dy)
                                        && previousResults[i][0] != -1) {
                                    int x1 = previousResults[i][0];
                                    int y1 = previousResults[i][1];
                                    int dx1 = previousResults[i][2];
                                    int dy1 = previousResults[i][3];
                                    int wordSize1 = search_words.get(i).length();
                                    int xWordLimit1 = dx1 * (wordSize1 - 1) + x1;
                                    int yWordLimit1 = dy1 * (wordSize1 - 1) + y1;
                                    if (Math.min(x, xWordLimit) >= Math.min(x1, xWordLimit1)
                                            && Math.max(x, xWordLimit) <= Math.max(x1, xWordLimit1)
                                            && Math.min(y, yWordLimit) >= Math.min(y1, yWordLimit1)
                                            && Math.max(y, yWordLimit) <= Math.max(y1, yWordLimit1)
                                            // If it is in diagonal, verify of it is in the same diagonal
                                            && (dx == 0 || dy == 0 || y1 + dy/dx * (x - x1) == y)) {
                                        contained = true;
                                        break;
                                    }
                                }
                            }
                            if (contained) {
                                continue;
                            }

                            // verify if the word fits in the puzzle and if it is the word
                            if (xWordLimit >= 0 && xWordLimit < lines.length
                                    && yWordLimit >= 0 && yWordLimit < lines[y].length) {
                                if (verifyWord(word, lines, x, y, dx, dy)) {
                                    result = new int[] { x, y, dx, dy };
                                    return result;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Verify if the word corresponds
     * 
     * @param word  the word to be verified
     * @param lines list with all lines
     * @param x     start letter x coordinate
     * @param y     start letter y coordinate
     * @param dx    x direction
     * @param dy    y direction
     * @return if word was found
     */
    public static boolean verifyWord(String word, char[][] lines, int x, int y, int dx, int dy) {
        for (int i = 0; i < word.length(); i++) {
            if (lines[y][x] != word.charAt(i)) {
                return false;
            }

            // Update coordinates
            x += dx;
            y += dy;
        }

        return true;
    }

    /**
     * Get the direction name based on dx and dy
     * 
     * @param dx
     * @param dy
     * @return the direction name (String)
     */
    public static String getDirectionName(int dx, int dy) {
        String direction = "";

        switch (dy) {
            case -1:
                direction += "Up";
                break;
            case 0:
                break;
            case 1:
                direction += "Down";
                break;

            default:
                System.err.println("getDirectionName: Something went wrong (dy)");
                break;
        }

        switch (dx) {
            case -1:
                direction += "Left";
                break;
            case 0:
                break;
            case 1:
                direction += "Right";
                break;

            default:
                System.err.println("getDirectionName: Something went wrong (dx)");
                break;
        }

        return direction;
    }

    /**
     * Print the result
     * 
     * @param words  list with all words
     * @param lines  list with all lines
     * @param result list with all results
     */
    public static void print_result(List<String> words, char[][] lines, int[][] result) {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            int x = result[i][0];
            int y = result[i][1];
            int dx = result[i][2];
            int dy = result[i][3];

            System.out.printf("%-20s %-10d %-7s %-3s\n", word.toLowerCase(), word.length(), (y + 1) + "," + (x + 1),
                    getDirectionName(dx, dy));
        }

        char[][] result_lines = new char[lines.length][lines[0].length];

        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length; j++) {
                result_lines[i][j] = '.';
            }
        }

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            int x = result[i][0];
            int y = result[i][1];
            int dx = result[i][2];
            int dy = result[i][3];
            for (int j = 0; j < word.length(); j++) {
                result_lines[y][x] = word.charAt(j);
                x += dx;
                y += dy;
            }
        }

        for (int i = 0; i < result_lines.length; i++) {
            for (int j = 0; j < result_lines[i].length; j++) {
                System.out.print(result_lines[i][j] + " ");
            }
            System.out.println();
        }

    }
}
