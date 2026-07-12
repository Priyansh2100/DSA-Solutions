class Solution {
    public int[] sortArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int temp =0;

       for(int k = min;k<=max;k++){
        while(map.containsKey(k) && map.get(k)!=0){
            nums[temp] = k;
            map.put(k,map.get(k)-1);
            temp++;

        }
       }
      
       return nums;
      
    }
}