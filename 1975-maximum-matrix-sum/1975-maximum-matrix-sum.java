class Solution {
    public long maxMatrixSum(int[][] matrix) {
         long sum = 0;
        int smallest = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int val = matrix[i][j];

                if (val < 0) count++;

                int abs = Math.abs(val);
                smallest = Math.min(smallest, abs);
                sum += abs;
            }
        }

        if (count % 2 != 0) {
            sum -= 2L * smallest;
        }

        return sum;
    }
}