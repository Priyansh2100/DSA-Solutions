class Solution {

    static int[] dp;

    public int maxrob(int[] nums,int n){

        if(n<0){
            return 0;
        }

        if(n==0){
            return nums[n];
        }

        if(dp[n]!=-1) return dp[n];

        dp[n] = Math.max(nums[n] + maxrob(nums,n-2),maxrob(nums,n-1));

        return Math.max(nums[n] + maxrob(nums,n-2),maxrob(nums,n-1));
    }
    public int rob(int[] nums) {
        int n = nums.length;

        dp = new int[n];

        Arrays.fill(dp,-1);

        return Math.max(maxrob(nums,n-1),maxrob(nums,n-2));
    }
}