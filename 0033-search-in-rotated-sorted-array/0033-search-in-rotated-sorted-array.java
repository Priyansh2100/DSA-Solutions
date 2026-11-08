class Solution {

    public int findPivot(int[] nums, int l, int r) {

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r;
    }

    public int binarySearch(int[] nums, int l, int r, int target) {

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {

        int n = nums.length;

        int pivot = findPivot(nums, 0, n - 1);

        if (nums[pivot] == target) {
            return pivot;
        }

        int idx = binarySearch(nums, pivot + 1, n - 1, target);

        if (idx != -1) {
            return idx;
        }

        return binarySearch(nums, 0, pivot - 1, target);
    }
}