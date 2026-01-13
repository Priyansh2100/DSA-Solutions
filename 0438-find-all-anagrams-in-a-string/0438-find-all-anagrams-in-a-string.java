class Solution {

    private boolean allZero(int[] count) {
        for (int num : count) {
            if (num != 0) return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        int[] count = new int[26];
        int k = p.length();

        // step 1: frequency of pattern
        for (char ch : p.toCharArray()) {
            count[ch - 'a']++;
        }

        int i = 0, j = 0;
        int n = s.length();

        // step 2: sliding window
        while (j < n) {

            // include current char
            count[s.charAt(j) - 'a']--;

            // step 3: when window size == pattern length
            if (j - i + 1 == k) {

                if (allZero(count)) {
                    ans.add(i); // store starting index
                }

                // step 4: remove left char (restore)
                count[s.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        return ans;
    }
}
