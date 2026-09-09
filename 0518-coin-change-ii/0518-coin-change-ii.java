class Solution {

    
    static long[][] dp;

    public long coinCount(int i, int[] coins,int amount){

        if(i == coins.length){
            if(amount == 0) return 1;

            return 0;
        }

        if(dp[i][amount] != -1) {
            return dp[i][amount];
        }

        long skip = coinCount(i+1,coins,amount);
        if(amount-coins[i]<0) return dp[i][amount] = skip;

        long take = coinCount(i,coins,amount-coins[i]);

        return dp[i][amount] = (skip + take);

    }
    public int change(int amount, int[] coins) {
        
        dp = new long[coins.length][amount + 1];

        for(int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = (int)coinCount(0,coins,amount);

        if(ans==Integer.MAX_VALUE) return -1;

        return ans;
    }
}