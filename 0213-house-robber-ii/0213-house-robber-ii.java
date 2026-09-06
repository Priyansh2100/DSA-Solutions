class Solution {

    static int[] dp;

    public int maxrob(int[] nums, int n, int start) {

        if(n < start) {
            return 0;
        }

        if(n == start) {
            return nums[n];
        }

         if(dp[n]!=-1) return dp[n];

         dp[n] = Math.max(
            nums[n] + maxrob(nums, n - 2, start),
            maxrob(nums, n - 1, start)
        );

        return Math.max(
            nums[n] + maxrob(nums, n - 2, start),
            maxrob(nums, n - 1, start)
        );
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1) {
            return nums[0];
        }

        dp = new int[n];

        Arrays.fill(dp,-1);

        // Case 1: Don't rob last house
        int case1 = maxrob(nums, n - 2, 0);

        Arrays.fill(dp, -1);

        // Case 2: Don't rob first house
        int case2 = maxrob(nums, n - 1, 1);

        return Math.max(case1, case2);
    }
}