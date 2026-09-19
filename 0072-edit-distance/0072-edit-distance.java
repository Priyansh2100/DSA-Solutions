class Solution {

    static int[][] dp;

    public int minSteps(int i, int j, StringBuilder a, StringBuilder b) {

        // word1 is finished
        if (i == -1) {
            return j + 1;
        }

        // word2 is finished
        if (j == -1) {
            return i + 1;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters are same
        if (a.charAt(i) == b.charAt(j)) {

            return dp[i][j] = minSteps(i - 1, j - 1, a, b);
        }

        // Delete
        int del = minSteps(i - 1, j, a, b);

        // Insert
        int ins = minSteps(i, j - 1, a, b);

        // Replace
        int rep = minSteps(i - 1, j - 1, a, b);

        return dp[i][j] = 1 + Math.min(del, Math.min(ins, rep));
    }

    public int minDistance(String word1, String word2) {

        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);

        int m = a.length();
        int n = b.length();

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return minSteps(m - 1, n - 1, a, b);
    }
}