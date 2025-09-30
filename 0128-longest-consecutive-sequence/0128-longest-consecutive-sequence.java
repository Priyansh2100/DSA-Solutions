class Solution {
    public int longestConsecutive(int[] nums) {
        // if(nums.length ==0){
        //     return 0;
        // }
        // int longest = 1;

        // Arrays.sort(nums);
        // int count = 1;
        // for(int i=0;i<nums.length-1;i++){
        //     if(nums[i] == nums[i+1]){
        //         continue;
        //     }
        //     if(nums[i]+1==nums[i+1]){
        //         count = count + 1;
                
        //     }
        //     else{
        //       longest = Math.max(count,longest);
        //       count=1;
        //     }
        // }
        // return Math.max(count, longest);
        int n = nums.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
        
    }
}