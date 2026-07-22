class Solution {

    Boolean[][] dp;

     private boolean solve(int i,int j,String s){

            if (i >= j)
            return true;

        if (dp[i][j] != null)
            return dp[i][j];

        if (s.charAt(i) != s.charAt(j))
            return dp[i][j] = false;

        return dp[i][j] = solve(i + 1, j - 1, s);

        }
    public String longestPalindrome(String s) {

        int n = s.length();

        dp = new Boolean[n][n];

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