class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        int count = 0;
        long sum = 0;
        long result = 0;

        HashSet<Integer> set = new HashSet<>();

        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            // Remove duplicates
            while (set.contains(nums[i])) {

                sum -= nums[j];
                set.remove(nums[j]);

                j++;
                count--;
            }

            // Add current element
            sum += nums[i];
            set.add(nums[i]);
            count++;

            // Window size becomes k
            if (count == k) {

                result = Math.max(result, sum);

                sum -= nums[j];
                set.remove(nums[j]);

                j++;
                count--;
            }
        }

        return result;
    }
}