class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 1;  // start from 1 to safely access arr[mid-1]
        int end = arr.length - 2;  // end at n-2 to safely access arr[mid+1]

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                // found the peak
                return mid;
            } 
            else if (arr[mid] < arr[mid + 1]) {
                // still on increasing slope → move right
                start = mid + 1;
            } 
            else {
                // on decreasing slope → move left
                end = mid - 1;
            }
        }

        // fallback (though this won't execute for valid mountain arrays)
        return 0;
    }
}
