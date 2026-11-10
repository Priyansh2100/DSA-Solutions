
import java.util.*;

class Solution {

    List<List<String>> result = new ArrayList<>();
    char[][] board;
    int n;

    public List<List<String>> solveNQueens(int n) {

        this.n = n;

        board = new char[n][n];

        // Initialize board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0);

        return result;
    }

    void solve(int row) {

        // Base case: All queens are placed
        if (row == n) {

            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            result.add(temp);
            return;
        }

        // Try every column in current row
        for (int col = 0; col < n; col++) {

            if (isSafe(row, col)) {

                // DO
                board[row][col] = 'Q';

                // RECURSE
                solve(row + 1);

                // UNDO (Backtracking)
                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(int row, int col) {

        int[][] dir = {
            {-1, -1},  // Upper-left
            {-1,  0},  // Up
            {-1,  1}   // Upper-right
        };

        for (int[] d : dir) {

            int r = row + d[0];
            int c = col + d[1];

            while (r >= 0 && c >= 0 && c < n) {

                if (board[r][c] == 'Q') {
                    return false;
                }

                r += d[0];
                c += d[1];
            }
        }

        return true;
    }
}



