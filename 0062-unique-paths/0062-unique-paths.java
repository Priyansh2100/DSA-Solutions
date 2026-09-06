class Solution {

    static int [][]dp;

    public int totalWays(int m, int n){

        if(m<0 || n<0) return 0;

        if(m == 0 && n == 0) return 1;

        if(dp[m][n]!=-1) return dp[m][n];

        dp[m][n] = totalWays(m-1,n) + totalWays(m,n-1);

        return totalWays(m-1,n) + totalWays(m,n-1);
    }
    public int uniquePaths(int m, int n) {

        dp = new int[m][n];


        for(int i =0;i<dp.length;i++){
            for(int j =0;j<dp[0].length;j++){
                dp[i][j] = -1;;
            }
        }
        
        return totalWays(m-1,n-1);
    }
}