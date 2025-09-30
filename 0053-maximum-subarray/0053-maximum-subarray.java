class Solution {
    public int maxSubArray(int[] nums) {
        int cursum = 0;
        int maxsum = Integer.MIN_VALUE;
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            cursum = cursum +nums[i];
            
            if(cursum>maxsum){
                maxsum = cursum;
            }
            if(cursum<0){
                cursum=0;
            }
            
        }
        return maxsum;
    }
}