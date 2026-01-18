class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();

        // build frequency map of t
        for (int k = 0; k < t.length(); k++) {
            map.put(t.charAt(k), map.getOrDefault(t.charAt(k), 0) + 1);
        }

        int count = map.size(); // number of chars still needed
        int i = 0, j = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (j < s.length()) {

            char rightChar = s.charAt(j);

            // include right character
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) {
                    count--;
                }
            }

            // when window is valid
            while (count == 0) {

                // update minimum window
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }

                char leftChar = s.charAt(i);

                // remove left character
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count++;
                    }
                }
                i++;
            }

            j++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
