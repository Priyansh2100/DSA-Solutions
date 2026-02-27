class Solution {
    public int[] countBits(int n) {
          int[] arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {

            int count = 0;
            int num = i;   // copy of i (important)

            while (num > 0) {
                if ((num & 1) == 1) {   // check last bit
                    count++;
                }
                num = num >> 1;   // shift copy, not i
            }

            arr[i] = count;   // store at correct index
        }

        return arr;
    }
}