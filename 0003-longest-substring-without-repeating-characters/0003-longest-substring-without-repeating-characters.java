class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right =0;

        int arr[] = new int[256];
       
        int maxCount =0;

        while(right < s.length()){

            char ch = s.charAt(right);
            arr[ch] = arr[ch] +1;

            while(arr[ch]>1){
              char c = s.charAt(left);
                arr[c]--;
                left++;
            }

            int count = right -left +1;

            maxCount = Math.max(count,maxCount);

            right++;
        }
        return maxCount;
    }
}