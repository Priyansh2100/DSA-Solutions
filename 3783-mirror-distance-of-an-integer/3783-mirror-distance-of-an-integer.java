class Solution {
    public int mirrorDistance(int n) {
        int temp =n;
        int reverse = 0;
        int i =0;

        while(n!=0){
            int mod = n %10;
            reverse = reverse * 10 + mod;
            n = n/10;
        }

        return Math.abs(temp-reverse);
    }
}