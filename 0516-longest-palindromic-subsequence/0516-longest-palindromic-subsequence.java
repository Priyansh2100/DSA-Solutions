class Solution {

    static int [][]dp;
    public int longestPalindromeSubseq(String s) {

          dp = new int[s.length()+1][s.length()+1];

        for(int i=0;i<=s.length();i++){
            for(int j =0;j<=s.length();j++){
                dp[i][j]= -1;
            }
        }

        int m = s.length();
        String reversed = new StringBuilder(s).reverse().toString();
        
        int n = reversed.length();

        

        return helper(s, reversed, 0, 0);
        
    }


    public int helper(String s, String reversed, int i, int j) {

        int m = s.length();
        int n = reversed.length();

        if(i==m || j ==n) return 0;


        if(dp[i][j]!=-1){
            return dp[i][j];
        }



        if(s.charAt(i)==reversed.charAt(j)){

         return dp[i][j] = 1+helper(s, reversed, i+1, j+1);
         
        }

        int take = helper(s,reversed,i+1,j);

        int skip = helper(s,reversed,i,j+1);

        return dp[i][j] = Math.max(take,skip);

    }
}