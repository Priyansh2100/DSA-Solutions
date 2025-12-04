class Solution {
    public void moveZeroes(int[] nums) {
         int i = 0 , k=0;
          int n = nums.length;
         // Store the length of the array
        // for (i=0;i<n;i++)
        // {
        //     if(nums[i]!=0)
        //     {
        //         nums[k]=nums[i];
        //         k++;
        //     }

        // }

        // for (int j=k;j<n;j++)
        // {
        // nums[j]=0;

        // }
        int j =-1;
        for( i =0;i<n;i++){
            if(nums[i]==0){
                j =i;
                break;
            }
        }

        for(i= j+1;i<n;i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;

            }
          
        }
    
    }
}