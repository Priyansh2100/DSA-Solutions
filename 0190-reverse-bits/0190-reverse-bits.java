class Solution {
    public int reverseBits(int n) {
         int result = 0;
        
        for (int i = 0; i < 32; i++) {
            int lsb = n & 1;                 // get last bit
            int reverseLsb = lsb << (31 - i); // move it to correct reversed position

            result = result | reverseLsb;    // add it to result

            n = n >> 1;               // unsigned right shift
        }
        
        return result;
    }
}