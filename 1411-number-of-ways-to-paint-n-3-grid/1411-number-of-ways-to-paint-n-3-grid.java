class Solution {

    static final int M = (int)(1e9 + 7);
    static String[] states = {
        "RYR", "RYG", "RGR", "RGY",
        "YRY", "YRG", "YGR", "YGY",
        "GRY", "GRG", "GYR", "GYG"
    };
    
    static long[][] memo;
    
    public int numOfWays(int n) {
        memo = new long[n + 1][12];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        long result = 0;
        // Try all 12 possible patterns for the first row
        for (int i = 0; i < 12; i++) {
            result = (result + solve(n - 1, i)) % M;
        }
        return (int)result;
    }
    
    private long solve(int n, int prev) {
        // Base case: all rows painted
        if (n == 0) {
            return 1;
        }
        
        // Memoization 
        if (memo[n][prev] != -1) {
            return memo[n][prev];
        }
        
        String last = states[prev];
        long result = 0;
        
        // Try all possible current states (patterns for current row)
        for (int curr = 0; curr < 12; curr++) {
            String currPattern = states[curr];
            boolean conflict = false;
            
            // Check for conflicts: same color in same column 
            for (int col = 0; col < 3; col++) {
                if (currPattern.charAt(col) == last.charAt(col)) {
                    conflict = true;
                    break;
                }
            }
            
            // If no conflict, recursively solve for remaining rows
            if (!conflict) {
                result = (result + solve(n - 1, curr)) % M;
            }
        }
        
        memo[n][prev] = result;
        return result;
    }
}