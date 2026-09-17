class Solution {

    static int dp[][];

    public int longestCommonSubsequence(String text1, String text2) {

        dp = new int[text1.length()+1][text2.length()+1];

        for(int i=0;i<=text1.length();i++){
            for(int j =0;j<=text2.length();j++){
                dp[i][j]= -1;
            }
        }

        int m = text1.length();
        int n = text2.length();

        

        return helper(text1, text2, 0, 0);

    }

    public int helper(String text1, String text2, int i, int j) {

        int m = text1.length();
        int n = text2.length();

        if(i==m || j ==n) return 0;


        if(dp[i][j]!=-1){
            return dp[i][j];
        }



        if(text1.charAt(i)==text2.charAt(j)){

         return dp[i][j] = 1+helper(text1, text2, i+1, j+1);
         
        }

        int take = helper(text1,text2,i+1,j);

        int skip = helper(text1,text2,i,j+1);

        return dp[i][j] = Math.max(take,skip);

    }
}