class Solution {
    public boolean halvesAreAlike(String s) {

        int n = s.length();
        int mid = n / 2;

        String firstPart = s.substring(0, mid);
        String secoundpart = s.substring(mid, n);

        int vowel = 0;

        for (int i = 0; i < firstPart.length(); i++) {
            if (Character.toLowerCase(firstPart.charAt(i)) == 'a' || Character.toLowerCase(firstPart.charAt(i)) == 'e'
                    || Character.toLowerCase(firstPart.charAt(i)) == 'i'
                    || Character.toLowerCase(firstPart.charAt(i)) == 'o'
                    || Character.toLowerCase(firstPart.charAt(i)) == 'u') {

                vowel++;

            }
        }
        

        for (int i = 0; i < secoundpart.length(); i++) {
            if (Character.toLowerCase(secoundpart.charAt(i)) == 'a' || Character.toLowerCase(secoundpart.charAt(i)) == 'e'
                    || Character.toLowerCase(secoundpart.charAt(i)) == 'i'
                    || Character.toLowerCase(secoundpart.charAt(i)) == 'o'
                    || Character.toLowerCase(secoundpart.charAt(i)) == 'u') {

                vowel--;

            }
        }
        if (vowel == 0) {
            return true;
        }
        return false;

    }
}