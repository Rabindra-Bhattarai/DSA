import java.util.List;
import java.util.ArrayList;

public class NQueen {

    // Method to check if it's safe to place a queen at chess[row][col]
    static boolean isSafe(int row, int col, char[][] chess) {
        // Checking horizontally
        for (int j = 0; j < chess.length; j++) {
            if (chess[row][j] == 'Q') {
                return false;
            }
        }

        // Checking vertically
        for (int i = 0; i < chess.length; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        // Checking upward left (diagonally)
        int i = row;
        for (int j = col; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // Checking downward right (diagonally)
        i = row;
        for (int j = col; i < chess.length && j < chess.length; i++, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // Checking upward right (diagonally)
        i = row;
        for (int j = col; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // Checking downward left (diagonally)
        i = row;
        for (int j = col; i < chess.length && j >= 0; i++, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Method to save the current board configuration into the list of solutions
    public static void saveBoard(char[][] chess, List<List<String>> allboard) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            String row = new String(chess[i]);
            board.add(row);
        }
        allboard.add(board);
    }

    // Recursive helper function to solve the N-Queen problem
    public static void helper(char[][] chess, int column, List<List<String>> allboard) {
        if (column == chess.length) {
            saveBoard(chess, allboard);
            return;
        }

        for (int i = 0; i < chess.length; i++) {
            if (isSafe(i, column, chess)) {
                chess[i][column] = 'Q'; // Place a queen
                helper(chess, column + 1, allboard); // Recur for the next column
                chess[i][column] = '.'; // Backtrack
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        int n = 4; // Size of the board (n x n)
        List<List<String>> allboard = new ArrayList<>();
        char[][] chess = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }

        helper(chess, 0, allboard);

        // Print all solutions
        for (List<String> board : allboard) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
