class Solution {
    public String orderlyQueue(String s, int k) {
        
        // case 1: k == 1 → find smallest rotation
        if (k == 1) {
            String min = s;

            for (int i = 1; i < s.length(); i++) {
                s = s.substring(1) + s.charAt(0); // rotate
                if (s.compareTo(min) < 0) {
                    min = s;
                }
            }
            return min;
        }

        // case 2: k > 1 → sort characters
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}