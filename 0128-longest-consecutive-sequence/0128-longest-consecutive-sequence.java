class Solution {

     public static int findMax(HashMap<Integer,Boolean> map, int k){

            int ans =0;

            while(map.containsKey(k)){
                ans++;
                k++;
            }
            return ans;
        }
    public int longestConsecutive(int[] nums) {

        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int num : nums){
            map.put(num,true);
        }

        for(int num : nums){
            if(map.containsKey(num-1)){
                map.put(num,false);
            }
        }

        int max =0;
        for(Integer i : map.keySet()){

            if(map.get(i) == true){
                max = Math.max(max, findMax(map,i));
            }

        }

       return max;
        
    }
}