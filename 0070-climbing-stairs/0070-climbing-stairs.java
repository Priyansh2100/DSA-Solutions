class Solution {

    int count=0;

    public int solve(int i,int n,int dp[]){
        if(i>n){
            return 0;
        }
        if(i==n){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int increase_one = solve(i+1,n,dp);
        int increase_two = solve(i+2,n,dp);

        return dp[i]= (increase_one + increase_two);

    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
       Arrays.fill(dp, -1);
     return solve(0,n,dp);
    }
}