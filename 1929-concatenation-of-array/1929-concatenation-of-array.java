class Solution {
    public int[] getConcatenation(int[] nums) {

        int n = nums.length * 2;

        int []ans = new int[n];
        int count =0;

        for(int i =0;i<nums.length;i++){
            ans[count] = nums[i];
            count++;
        }
        for(int j = 0;j<nums.length;j++){
            ans[count] = nums[j];
            count++;
        }
        return ans;
        
    }
}