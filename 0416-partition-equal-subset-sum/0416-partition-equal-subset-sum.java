class Solution {

    static Boolean[][] dp;

    static boolean subset(int idx, int[] nums, int sum) {

        if(sum == 0)
            return true;

        if(sum < 0)
            return false;

        if(idx == nums.length)
            return false;

        if(dp[idx][sum] != null)
            return dp[idx][sum];

        boolean take = subset(idx + 1, nums, sum - nums[idx]);

        boolean skip = subset(idx + 1, nums, sum);

        return dp[idx][sum] = take || skip;
    }

    public boolean canPartition(int[] nums) {

        int total = 0;

        for(int num : nums) {
            total += num;
        }

        if(total % 2 != 0)
            return false;

        int target = total / 2;

        dp = new Boolean[nums.length][target + 1];

        return subset(0, nums, target);
    }
}