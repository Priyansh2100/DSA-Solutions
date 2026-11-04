class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int count = 0;

        int sum = 0;

        double result =Integer.MIN_VALUE;

        int j =0;
        
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            count++;

            if (count == k) {

                result = Math.max(result, (double) sum / k);

                sum -= nums[j];
                j++;
                count--;
            }
        }

        return result;
    }
}