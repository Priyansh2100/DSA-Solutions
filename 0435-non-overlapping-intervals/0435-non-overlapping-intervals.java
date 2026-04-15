class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         if (intervals.length == 0) return 0;

        // sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 1;  // first interval always selected
        int lastEnd = intervals[0][1];

        // greedy selection
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEnd) {
                count++;
                lastEnd = intervals[i][1];
            }
        }

        // removals
        return intervals.length - count;
    }
}