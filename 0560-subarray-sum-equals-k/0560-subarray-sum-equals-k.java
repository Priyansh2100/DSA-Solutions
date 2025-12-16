class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
         int count=0;

         int val =0;
        // for(int i =0;i<n;i++){
        //     int sum = 0;
        //     for(int j = i;j<n;j++){
        //         sum = sum + nums[j];
        //         if(sum == k){
        //             count++;
        //         }
        //     }
        // }
        // return count;

        //Prefix Sum code 
        int prefixsum[] = new int[n];
        prefixsum[0] = nums[0];

        for(int i =1;i<n;i++){
            prefixsum[i] = prefixsum[i-1] + nums[i];
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int j = 0;j<n;j++){

            if(prefixsum[j] == k){
              count++;
            }
             val = prefixsum[j] -k;

             if(map.containsKey(val)){
                count += map.get(val);
             }
             map.put(prefixsum[j], map.getOrDefault(prefixsum[j], 0) + 1);
        }

        return count;

    }
}