class Solution {

    static int sum;

    public int ways(int i, int[] arr, int target, int[][] dp) {

        if (i == arr.length) {
            if (target == 0) return 1;
            else return 0;
        }

        if (target > sum || target < -sum) return 0;

        if (dp[i][target + sum] != -1)
            return dp[i][target + sum];

        int add = ways(i + 1, arr, target - arr[i], dp);

        int sub = ways(i + 1, arr, target + arr[i], dp);

        return dp[i][target + sum] = add + sub;
    }

    public int findTargetSumWays(int[] arr, int target) {

        sum = 0;
        int n = arr.length;

        for (int ele : arr)
            sum += ele;

        int[][] dp = new int[n][2 * sum + 1];

        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        return ways(0, arr, target, dp);
    }
}