class Solution {

    int[][] t;

    public int solve(int i, int j, String s1, String s2) {

        // Base cases
        if (i == s1.length() && j == s2.length()) {
            return 0;
        }

        if (i == s1.length()) {
            return s2.charAt(j) + solve(i, j + 1, s1, s2);
        }

        if (j == s2.length()) {
            return s1.charAt(i) + solve(i + 1, j, s1, s2);
        }

        // Memoization check
        if (t[i][j] != -1) {
            return t[i][j];
        }

        // If characters are equal → no delete cost
        if (s1.charAt(i) == s2.charAt(j)) {
            t[i][j] = solve(i + 1, j + 1, s1, s2);
        } 
        else {
            // Delete from s1 OR delete from s2
            int deleteFromS1 = s1.charAt(i) + solve(i + 1, j, s1, s2);
            int deleteFromS2 = s2.charAt(j) + solve(i, j + 1, s1, s2);

            t[i][j] = Math.min(deleteFromS1, deleteFromS2);
        }

        return t[i][j];
    }

    public int minimumDeleteSum(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        t = new int[m][n];

        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, s1, s2);
    }
}
