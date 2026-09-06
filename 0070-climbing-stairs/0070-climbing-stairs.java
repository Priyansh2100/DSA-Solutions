class Solution {

    static int []dp;

    public int maxclimb(int n){

        if(n <0) return 0;

        if(n == 0){
            return 1;
        }

        if(dp[n]!=-1)  return dp[n];

        dp[n] = maxclimb(n-1) + maxclimb(n-2);;

        return maxclimb(n-1) + maxclimb(n-2);
    }
    public int climbStairs(int n) {

        dp = new int[n+1];

        Arrays.fill(dp,-1);
        
        return maxclimb(n);
    }
}