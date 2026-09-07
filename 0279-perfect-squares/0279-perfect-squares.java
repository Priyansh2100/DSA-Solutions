import java.util.Arrays;

class Solution {

    static int[] dp;

    public boolean isPerfect(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) return true;

        return false;
    }

    public int solve(int n) {

        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        if (isPerfect(n)) return dp[n] = 1;

        int min = n;

        for (int i = 1; i * i <= n; i++) {

            int square = i * i;

            // 1+ esliye add kra h 
            // n = 12
            // square = 4

            //Humne ek square already use kar liya:  
            //
            int count = 1 + solve(n - square);

            min = Math.min(count, min);
        }

        return dp[n] = min;
    }

    public int numSquares(int n) {

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n);
    }
}