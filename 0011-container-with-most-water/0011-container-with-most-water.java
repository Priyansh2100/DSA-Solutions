class Solution {
    public int maxArea(int[] height) {
        int maxwater = 0;
        int lb = 0;
        int rb = height.length-1;
        int area = 0;
        
        while(lb < rb){
            int width = rb - lb;
            int heights = Math.min(height[lb],height[rb]);
             area = width*heights;

            maxwater =Math.max(maxwater, area);

        if(height[lb]>height[rb]){
            rb--;
        }else{
            lb++;
        }
        }
        return maxwater;
    }
}