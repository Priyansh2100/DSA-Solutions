class Solution {

    static int [][]dp;

    public int minSum(int m, int n, int grid[][]) {

        //for this case : return Maximun because agr hum 0 return kar denge to , algo use cheapest path samaj lega 
        if (m < 0 || n < 0)
            return 1000000000;

        if (m == 0 && n == 0)
            return grid[m][n];

        if (dp[m][n] != -1)
            return dp[m][n];

        dp[m][n] = Math.min(grid[m][n]+minSum(m - 1, n, grid),grid[m][n]+minSum(m, n - 1, grid));

        return Math.min(grid[m][n]+minSum(m - 1, n, grid),grid[m][n]+minSum(m, n - 1, grid));

    }

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n];

        

        for(int i =0;i<dp.length;i++){
            for(int j =0;j<dp[0].length;j++){
                dp[i][j] = -1;;
              //  size++;
            }
        }
        

        return minSum(m-1,n-1,grid);

    }
}