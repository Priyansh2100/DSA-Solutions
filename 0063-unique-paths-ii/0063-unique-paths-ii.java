class Solution {

    static int [][]dp;

    public int totalWays(int m, int n,int obstacleGrid[][]){


        if(m<0 || n<0) return 0;

        
        if(obstacleGrid[m][n] == 1) return 0;

        if(m == 0 && n == 0) return 1;

        if(dp[m][n]!=-1) return dp[m][n];

        dp[m][n] = totalWays(m-1,n,obstacleGrid) + totalWays(m,n-1,obstacleGrid);

        return totalWays(m-1,n,obstacleGrid) + totalWays(m,n-1,obstacleGrid);

     }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        dp = new int[m][n];

        

        for(int i =0;i<dp.length;i++){
            for(int j =0;j<dp[0].length;j++){
                dp[i][j] = -1;;
              //  size++;
            }
        }
        

        return totalWays(m-1,n-1,obstacleGrid);
    }
}