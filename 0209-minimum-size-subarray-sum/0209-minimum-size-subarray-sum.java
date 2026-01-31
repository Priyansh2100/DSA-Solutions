class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i =0;
       
        int sum =0;
        int n = nums.length;
        int minlen = Integer.MAX_VALUE;
       
       for(int j=0;j<n;j++){
        sum = sum + nums[j];

        while(sum >= target){
           minlen = Math.min(minlen, j-i+1);
           sum = sum - nums[i];
           i++;
        }

       }
       return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}