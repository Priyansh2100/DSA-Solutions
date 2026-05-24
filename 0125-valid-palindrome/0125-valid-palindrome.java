class Solution {
    public boolean isPalindrome(String s) {

         StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if ((ch >= 'a' && ch <= 'z') ||
    (ch >= 'A' && ch <= 'Z') ||
    (ch >= '0' && ch <= '9')) {

    sb.append(Character.toLowerCase(ch));
}
        }

        String str = sb.toString();

        
        int i =0;
        int j = str.length()-1;
        
        while(i<j){
            
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}