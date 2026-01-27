class Solution {
    public String reverseWords(String s) {
        String arr[] = s.trim().split("\\s+");
        String str = "";

        for (int i = arr.length - 1; i >= 0; i--) {
            str = str + arr[i];
            if (i > 0) {
                str = str + " ";
            }

        }
        return str;
    }
}