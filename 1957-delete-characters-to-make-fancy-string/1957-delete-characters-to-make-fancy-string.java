class Solution {
    public String makeFancyString(String s) {
         StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            int len = ans.length();

            // If last two characters are same as current character, skip it
            if (len >= 2 &&
                ans.charAt(len - 1) == ch &&
                ans.charAt(len - 2) == ch) {
                continue;
            }

            ans.append(ch);
        }

        return ans.toString();
    }
}