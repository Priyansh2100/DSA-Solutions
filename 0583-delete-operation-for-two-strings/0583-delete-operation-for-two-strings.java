class Solution {

    static int[][] dp;

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int lcs = helper(word1, word2, 0, 0);

        return m + n - (2 * lcs);
    }

    public int helper(String word1, String word2, int i, int j) {

        if (i == word1.length() || j == word2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {

            return dp[i][j] =
                    1 + helper(word1, word2, i + 1, j + 1);
        }

        int take = helper(word1, word2, i + 1, j);

        int skip = helper(word1, word2, i, j + 1);

        return dp[i][j] = Math.max(take, skip);
    }
}