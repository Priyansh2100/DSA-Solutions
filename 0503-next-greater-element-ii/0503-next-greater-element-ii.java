class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int totallength = nums.length + nums.length;
        int[] arr = new int[totallength];
        int[] result = new int[nums.length];

        Arrays.fill(result, -1);

        for(int i = 0;i<nums.length;i++){
            arr[i] = nums[i];
        }

        for(int i = nums.length;i<totallength;i++){
            int k = i% nums.length;
            arr[i] = nums[k];
        }

        Stack<Integer> stk = new Stack<>();

        for(int i = arr.length-1;i>=0;i--){
            while (!stk.isEmpty() && stk.peek() <= arr[i]) {
                stk.pop();
            }

            if (i < nums.length) {
                if (!stk.isEmpty()) {
                    result[i] = stk.peek();
                } else {
                    result[i] = -1;
                }
            }
            stk.add(arr[i]);
            
         
        }
        return result;
    }
}