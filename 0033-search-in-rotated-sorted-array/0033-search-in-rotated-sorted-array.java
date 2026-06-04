class Solution {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        int n = nums.length - 1;

        while (l <= r) {

            if (nums[l] <= nums[r]) {

                int pivot = l;

                int ans1 = BinarySearch(nums, 0, pivot - 1, target);
                int ans2 = BinarySearch(nums, pivot, n, target);

                if (ans1 != -1)
                    return ans1;
                return ans2;
            }

            int mid = l + (r - l) / 2;

            int next = (mid + 1) % nums.length;
            int prev = (mid + nums.length - 1) % nums.length;

            // minimum element found
            if (nums[mid] <= nums[next] &&
                    nums[mid] <= nums[prev]) {
                // return mid;

                int ans1 = BinarySearch(nums, 0, mid - 1, target);

                int ans2 = BinarySearch(nums, mid, n, target);

                if (ans1 == -1 && ans2 == -1) {

                    return -1;

                }

                else if (ans1 != -1) {

                    return ans1;

                }

                else {

                    return ans2;

                }
            }

            // left half sorted
            if (nums[l] <= nums[mid]) {
                l = mid + 1;
            }
            // right half sorted
            else {
                r = mid - 1;
            }
        }
        return -1;

    }

    private int BinarySearch(int[] arr, int l, int r, int target) {
       
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}