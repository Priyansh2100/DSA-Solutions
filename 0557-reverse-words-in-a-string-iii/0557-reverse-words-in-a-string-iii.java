class Solution {
    public String reverseWords(String s) {

        String strArray[]=s.split("\\s");
        String ans="";
        for(int i=0;i<strArray.length;i++)
        {
         String a = strArray[i];
         for( int j=a.length()-1;j>=0;j--){
            ans = ans + a.charAt(j);

            if(j==0 && i!=strArray.length-1){
                ans = ans + " ";
            }


         }
        }
        return ans ;
        
    }
}