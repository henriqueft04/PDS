public class Test {
    public static void main(String[] args) {
        char[][] lines = {
            {'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H'},
            {'I', 'J', 'K', 'L'},
            {'M', 'N', 'O', 'P'}
        };

        System.out.println(WordSearchSolver.verifyWord("ABCD", lines, 0, 0, 1, 0));
        System.out.println(WordSearchSolver.verifyWord("POIU", lines, 0, 0, 1, 0));
        System.out.println(WordSearchSolver.verifyWord("BFJN", lines, 1, 0, 0, 1));
        System.out.println(WordSearchSolver.verifyWord("AFK", lines, 0, 0, 1, 1));

        int[][] result = new int[4][4];
        result[0] = WordSearchSolver.searchWord("ABCD", lines, result);
        System.out.println("ABCD: " + result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
        result[1] = WordSearchSolver.searchWord("POIU", lines, result);
        System.out.println("POIU: " + result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
        result[2] = WordSearchSolver.searchWord("BFJN", lines, result);
        System.out.println("BFJN: " + result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
        result[3] = WordSearchSolver.searchWord("AFK", lines, result);
        System.out.println("AFK: " + result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
    }
}
