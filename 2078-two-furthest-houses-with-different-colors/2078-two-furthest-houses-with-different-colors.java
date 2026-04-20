class Solution {
    public int maxDistance(int[] colors) {
         int n = colors.length;
        int result = 0;

        int i = 0;
        while (colors[i] == colors[n - 1]) {
            i++;
        }
        result = Math.max(result, (n - 1) - i);

        i = n - 1;
        while (colors[0] == colors[i]) {
            i--;
        }
        result = Math.max(result, i);

        return result;
    }
}