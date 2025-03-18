import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.io.BufferedReader;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.io.PrintWriter;

public class WSGenerator {

    public static void main(String[] args) throws Exception {
        
        boolean[] flags = {false, false, false};

        String iFile = null;
        String oFile = null;
        int size = 0;

        for (int i = 0; i < args.length; i+=2) {
            switch (args[i]) {
                case "-i":
                    if (flags[0]) {
                        invalidArgs();
                    }
                    iFile = args[i+1];
                    flags[0] = true;
                    break;
                case "-s":
                    if (flags[1]) {
                        invalidArgs();
                    }
                    size = Integer.parseInt(args[i+1]);
                    flags[1] = true;
                    break;
                case "-o":
                    if (flags[2]) {
                        invalidArgs();
                    }
                    oFile = args[i+1];
                    flags[2] = true;
                    break;
                default:
                    invalidArgs();
            }
        }

        // Check compulsory arguments
        for (int i = 0; i < 2; i++) {
            if (!flags[i]) {
                invalidArgs();
            }
        }

        // Check if the puzzle size is valid
        if (size < 1 || size > 40) {
            System.err.println("Invalid puzzle size");
            System.exit(1);
        }


        List<String> words = getWords(args[1]);

        // Verify if the size is valid
        // To be valid, the size must be greater than the biggest word ...
        for (String word : words) {
            if (word.length() > size) {
                System.err.println("Word " + word + " is too big for the puzzle size.");
                System.exit(1);
            }
        }
        // ... and if the size is greater than the number of words,
        // we can guarantee that the puzzle will have at least one valid distribution
        if (size < words.size()) {
            System.err.println("Puzzle size is too small for the words provided.");
            System.exit(1);
        }

        char[][] puzzle = createPuzzle(size, words);

        PrintWriter writer;
    
        if (oFile != null) {
            writer = new PrintWriter(oFile, "UTF-8");
        } else {
            writer = new PrintWriter(System.out);
        }

        for( int i = 0; i < size; i++ ) {
            for( int j = 0; j < size; j++ ) {
                if ( puzzle[i][j] == 0 ) {
                    char letter = (char)('A' + (int)(Math.random() * 26));
                    writer.write(Character.toUpperCase(letter));
                } else {
                    writer.write(Character.toUpperCase(puzzle[i][j]));
                }
            }
            writer.write("\n");
        }
        for( String word : words ) {
            writer.write(word + " ");
        }

        writer.close();

    }

    public static void invalidArgs() {
        System.err.println("Usage: WSGenerator -i <input_file> -s <puzzle_size> [-o] <output_file>");
        System.exit(1);
    }

    public static List<String> getWords(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
        List<String> searched_words = new ArrayList<String>();
        Pattern chars_regex = Pattern.compile("[a-zA-Z]+");
        String split_regex = ";|,| |\\n";

        while (scanner.hasNextLine()) {
            String words_line = scanner.nextLine();
            String[] words = words_line.split(split_regex);
            for (String word : words) {
                if (word.toUpperCase().equals(word) || !chars_regex.matcher(word).matches() || word.isEmpty()) {
                    System.err.println("Invalid puzzle");
                    System.exit(1);
                }
                searched_words.add(word);
            }
        }

        scanner.close();
        return searched_words;
    }


    public static char[][] createPuzzle(int size, List<String> words) {
        char[][] puzzle; // Default value is 0
        List<String> wordsToPlace;

        do {
            // Reset the puzzle
            puzzle = new char[size][size];
            wordsToPlace = new ArrayList<>(words);
            for (String word : words) {
                boolean placed = tryPlaceWord(puzzle, word, size);
                if (placed) {
                    wordsToPlace.remove(word);
                }
            }
        } while (!wordsToPlace.isEmpty());

        return puzzle;
    }

    private static boolean tryPlaceWord(char[][] puzzle, String word, int size) {
        for (int attempts = 0; attempts < size * size; attempts++) {
            int x = (int) (Math.random() * size);
            int y = (int) (Math.random() * size);
            int dx = (int) (Math.random() * 3) - 1;
            int dy = (int) (Math.random() * 3) - 1;
            
            if (dx == 0 && dy == 0) continue; // se for 0,0 não é nada
            if (canPlaceWord(puzzle, word, x, y, dx, dy, size)) {
                placeWord(puzzle, word, x, y, dx, dy);
                return true;
            }
        }
        return false;
    }

    private static boolean canPlaceWord(char[][] puzzle, String word, int x, int y, int dx, int dy, int size) {
        int xLimit = x + (word.length() - 1) * dx;
        int yLimit = y + (word.length() - 1) * dy;
        if (xLimit < 0 || yLimit < 0 || xLimit >= size || yLimit >= size) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            int newX = x + i * dx;
            int newY = y + i * dy;
            if (puzzle[newX][newY] != 0) {
                if (puzzle[newX][newY] != word.charAt(i)) {
                    return false;
                }
                count++;
            }
        }

        if (count == word.length()) {
            return false; // The word is contained in another word in the same place
        }

        return true;
    }

    private static void placeWord(char[][] puzzle, String word, int x, int y, int dx, int dy) {
        for (int i = 0; i < word.length(); i++) {
            int newX = x + i * dx;
            int newY = y + i * dy;
            puzzle[newX][newY] = word.charAt(i);
        }
    }
}
