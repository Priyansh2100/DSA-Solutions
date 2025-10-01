class Solution {
    public int[][] merge(int[][] intervals) {
          if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort the intervals based on their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            // Check for overlap
            if (currentInterval[1] >= nextInterval[0]) {
                // Merge overlapping intervals
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // Add the non-overlapping interval to the result
                result.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        // Add the last interval to the result
        result.add(currentInterval);

        return result.toArray(new int[result.size()][]);
    

    }
}