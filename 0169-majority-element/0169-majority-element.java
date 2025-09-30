class Solution {
    public int majorityElement(int[] nums) {
    //    HashMap<Integer, Integer> counts = new HashMap<>();

    //     // Count occurrences of each element
    //     for (int num : nums) {
    //         counts.put(num, counts.getOrDefault(num, 0) + 1);
    //     }

    //     int majorityCount = nums.length / 2;

    //     // Find the element with count > majorityCount
    //     for (int num : nums) {
    //         if (counts.get(num) > majorityCount) {
    //             return num;
    //         }
    //     }
    //     return -1;

    HashMap<Integer, Integer> counts = new HashMap<>();

    int majorityCount = nums.length/2;

    for(int num : nums){
        counts.put(num,counts.getOrDefault(num,0)+1);
    }

    for(int num : nums){
        if(counts.get(num)>majorityCount){
            return num;
        }
    }
    return -1;
        
    }
}