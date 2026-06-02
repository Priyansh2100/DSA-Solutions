class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        
        //Right Smallest Nearest
        Stack<Integer> stk = new Stack<>();
        
        int right[] = new int[n];

        for(int i= n-1;i>=0;i--){

            while(stk.size()>0 && heights[stk.peek()] >=heights[i]){
                stk.pop();
            }

            if(stk.isEmpty()){
                right[i] = n;  //For height 1, there is no smaller element on the right. The rectangle can extend till the end of the array.
            }
            else{
                right[i] = stk.peek();
            }
            stk.push(i);
        }

        stk.clear();

        int left[] = new int[n];

        //Left Small Nearest
         for(int i= 0;i<n;i++){

            while(stk.size()>0 && heights[stk.peek()] >=heights[i]){
                stk.pop();
            }

            if(stk.isEmpty()){
                left[i] = -1;
            }
            else{
                left[i] = stk.peek();
            }
            stk.push(i);
        }

        int ans =0;

        int currArea = 0;


        for(int i =0;i<n;i++){
        
        currArea = heights[i] * (right[i]-left[i]-1);
        ans = Math.max(ans,currArea);
        }

        return ans;
    }
}