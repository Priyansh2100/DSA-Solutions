class Solution {
    public String makeGood(String s) {
        String result = "";
        int index = -1;

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            if (index == -1) {
                result = result + temp;
                index++;
            } else if (Character.toLowerCase(temp) == Character.toLowerCase(result.charAt(index))
                    && temp != result.charAt(index)) {

                result = result.substring(0, index);
                index--;
            } else {
                result = result + temp;
                index++;
            }
        }

        return result;

    }
}