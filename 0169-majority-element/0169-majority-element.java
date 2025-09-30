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

    int element = nums[0];
    int count=0;

    for(int i =0;i<nums.length;i++){
        if(element == nums[i]){
            count++;
        }
        else{
            count--;
        }
        if(count==0 || count<0){
            element = nums[i];
            count++;

        }


    }
    return element;
        
    }
}