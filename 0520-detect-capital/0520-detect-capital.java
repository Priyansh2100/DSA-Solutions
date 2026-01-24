class Solution {
    public boolean detectCapitalUse(String word) {
             int count_upper = 0;
            int count_lower = 0;
        
        for(int i =0;i<word.length();i++){
             
            char ch = word.charAt(i);
       
            if(Character.isUpperCase(ch)){
                count_upper++;
                continue;
            }
            if(Character.isLowerCase(ch)){
                count_lower++;
                continue;
            }
           
            
        }
         if(count_upper == 1 && Character.isUpperCase(word.charAt(0)) && count_lower == word.length()-1){
             return true;
            }

            if(count_upper == word.length()){
                return true;
            }
            if(count_lower == word.length()){
                return true;
            }
        return false;
    }
}