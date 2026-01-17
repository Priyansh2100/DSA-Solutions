class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0, right = 0;
        int[] freq = new int[256]; // ASCII characters
        int maxLength = 0;

        while (right < s.length()) {

            char currentChar = s.charAt(right);
            freq[currentChar]++;

            // shrink window if duplicate exists
            while (freq[currentChar] > 1) {
                char leftChar = s.charAt(left);
                freq[leftChar]--;
                left++;
            }

            // update max length
            int currentWindowSize = right - left + 1;
            maxLength = Math.max(maxLength, currentWindowSize);

            right++;
        }

        return maxLength;
    }
}
