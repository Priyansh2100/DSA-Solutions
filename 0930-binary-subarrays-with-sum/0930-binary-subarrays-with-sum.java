class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int l = 0;
        int r = 0;
        int count = 0;
        int sum = 0;

        while (r < nums.length) {

            sum += nums[r];

            // shrink if sum > goal
            while (l < r && sum > goal) {
                sum -= nums[l];
                l++;
            }

            // count all valid subarrays ending at r
            if (sum == goal) {
                count++;

                int temp = l;
                // handle leading zeros
                while (temp < r && nums[temp] == 0) {
                    count++;
                    temp++;
                }
            }

            r++;
        }
        return count;
    }
}