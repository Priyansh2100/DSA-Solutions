class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            // Compare substring of length m starting from i
            if (haystack.substring(i, i + m).equals(needle)) {
                return i; // found
            }
        }

        return -1; // not found

        //   return haystack.indexOf(needle);
    }
}
