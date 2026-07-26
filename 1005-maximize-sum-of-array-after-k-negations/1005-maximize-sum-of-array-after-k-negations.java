class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {

        Arrays.sort(nums);

        // Flip negative numbers
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;

        // Find sum and smallest absolute value
        for (int num : nums) {
            sum += num;
            min = Math.min(min, Math.abs(num));
        }

        // If one flip is still left
        if (k % 2 == 1) {
            sum -= 2 * min;
        }

        return sum;
    }
}