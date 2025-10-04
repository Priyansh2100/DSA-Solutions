class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Step 1: Transpose the matrix
        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         // Swap matrix[i][j] with matrix[j][i]
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[j][i];
        //         matrix[j][i] = temp;
        //     }
        // }
        
        // Step 2: Reverse each row
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n / 2; j++) {
        //         // Swap matrix[i][j] with matrix[i][n - 1 - j]
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[i][n - 1 - j];
        //         matrix[i][n - 1 - j] = temp;
        //     }
        // }
        int ans[][] = new int[n][n];

        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                ans[j][n-1-i] = matrix[i][j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                matrix[i][j] = ans[i][j];

            }
        }
      
    }
}