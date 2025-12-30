import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        // step 1: store tasks with index
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0]; // enqueueTime
            arr[i][1] = tasks[i][1]; // processingTime
            arr[i][2] = i;           // index
        }

        // step 2: sort by enqueueTime
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // step 3: min heap (processingTime, index)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) return a[1] - b[1];
                return a[2] - b[2];
            }
        );

        int time = 0;
        int i = 0;
        int idx = 0;
        int[] result = new int[n];

        // step 4: simulation
        while (i < n || !pq.isEmpty()) {

            // if cpu idle and next task not yet arrived
            if (pq.isEmpty() && time < arr[i][0]) {
                time = arr[i][0];
            }

            // add all available tasks
            while (i < n && arr[i][0] <= time) {
                pq.offer(arr[i]);
                i++;
            }

            // process next task
            int[] task = pq.poll();
            result[idx++] = task[2];
            time += task[1];
        }

        return result;
    }
}
