class Solution {
    public void setZeroes(int[][] matrix) {
         int m = matrix.length, n = matrix[0].length;

        int[] row = new int[m]; // to mark zero rows
        int[] col = new int[n]; // to mark zero cols

        // Step 1: Mark rows & cols that have a 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Step 2: Update matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}