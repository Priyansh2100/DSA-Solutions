class Solution {

     private boolean solve(int i,int j,String s){

            while(i<=j){

                if(s.charAt(i)==s.charAt(j)){
                    i++;
                    j--;
                }
                else{
                    return false;
                }
            }
            return true;
        }
    public String longestPalindrome(String s) {

        int max=0;
        int startPoint = 0;

        if(s.length()==1){
            return s;
        }
        

        for(int i =0;i<s.length();i++){
            for(int j=i;j<s.length();j++){

                if(solve(i,j,s)){
                    if(j-i+1>max){
                        max = j-i+1;
                        startPoint = i;
                    }

                }
            }
        }
        return s.substring(startPoint,startPoint+max);
    }
}