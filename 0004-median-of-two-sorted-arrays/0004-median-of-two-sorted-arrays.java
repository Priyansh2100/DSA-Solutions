import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();

        // Add elements from nums1 to the ArrayList
        for(int i = 0; i < nums1.length; i++){
            arr.add(nums1[i]);
        }
        
        // Add elements from nums2 to the ArrayList
        for(int i = 0; i < nums2.length; i++){
            arr.add(nums2[i]);
        }

        // Sort the combined ArrayList
        Collections.sort(arr);

        int size = arr.size();

        // Check if the size is odd
        if (size % 2 != 0) {
            // Return the middle element for odd-sized arrays
            return arr.get(size / 2);
        } else {
            // Calculate the average of the two middle elements for even-sized arrays
            double a = arr.get(size / 2);
            double b = arr.get(size / 2 - 1);
            return (a + b) / 2.0;
        }
    }
}
