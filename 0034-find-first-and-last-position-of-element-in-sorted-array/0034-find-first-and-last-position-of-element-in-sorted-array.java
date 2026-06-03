class Solution {
    public int[] searchRange(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        int[] ans = {-1, -1};

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {

                int temp = mid;

                while (mid >= 0 && nums[mid] == target) {
                    mid--;
                }
                ans[0] = mid + 1;

                mid = temp;

                while (mid < nums.length && nums[mid] == target) {
                    mid++;
                }
                ans[1] = mid - 1;

                return ans;

            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}