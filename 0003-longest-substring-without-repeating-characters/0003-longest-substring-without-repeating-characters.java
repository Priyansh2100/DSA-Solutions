class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int l = 0;
        int r = 0;
        int maxlen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            while (map.get(s.charAt(r)) > 1) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            int len = r - l + 1;
            maxlen = Math.max(len, maxlen);

            r++;
        }
        return maxlen;
    }
}
