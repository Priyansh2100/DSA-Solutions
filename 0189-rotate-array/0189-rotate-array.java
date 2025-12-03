class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        // k=k%n;

        // int[] temp = new int[k];

        // for(int i=0;i<k;i++){
        //     temp[i] = nums[n-k+i];
        // }

        // for(int i=n-1;i>=k;i--){
        //     nums[i] = nums[i-k];
        // }

        // for(int i=0;i<k;i++){
        //     nums[i] = temp[i];
        // }
         k = k%nums.length;
        reverse(nums, 0, (nums.length)-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }

    public static void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}