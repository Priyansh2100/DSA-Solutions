class Solution {
    public double myPow(double x, int n) {

        long N = n;
        
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;

        while (N > 0) {
            if ((N & 1) == 1) {   // odd
                result *= x;
            }
            x *= x;              // square
            N >>= 1;             // divide by 2
        }

        return result;
    }
}