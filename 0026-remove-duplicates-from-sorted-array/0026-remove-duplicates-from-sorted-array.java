class Solution {
    public int removeDuplicates(int[] nums) {
        // HashSet<Integer> set = new HashSet<>();
        // int res = 0;
        
        // for (int i = 0; i < nums.length; i++) {
        //     if (!set.contains(nums[i])) {
        //         nums[res++] = nums[i];
        //         set.add(nums[i]);
        //     }
        // }
        // return res;

        int i =0;
        for(int j =1 ;j<nums.length;j++){
          if(nums[j]!=nums[i]){
            nums[i+1]=nums[j];
            i++;
          }
        }
        return i+1;
        
    }
}