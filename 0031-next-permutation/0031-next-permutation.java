class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;

        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot==-1){
            int p1 = 0, p2 = n - 1;
            while (p1 < p2) {
         int tmp = nums[p1];
         nums[p1] = nums[p2];
         nums[p2] = tmp;
         p1++;
         p2--;
           }
           return;
        }

        for(int i=n-1;i>pivot;i--){
            if(nums[i]>nums[pivot]){
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot]= temp;
                break;
            }
        }
        int p3 = pivot+1, p4 = n - 1;
            while (p3 < p4) {
         int tmp = nums[p3];
         nums[p3] = nums[p4];
         nums[p4] = tmp;
         p3++;
         p4--;
           }
    }
}