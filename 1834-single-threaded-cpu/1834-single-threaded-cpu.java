class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        int [][]arr = new int[n][3];

        for(int i =0;i<n;i++){
            
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr,(a,b)->{ return a[0]-b[0]; });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{

            if(a[1]!=b[1]){
              return  a[1]-b[1];
            }
            return a[2]-b[2];
        });

        int i =0;
        int timer =0;
        int idx =0;
       int[] result = new int[n];

        while(!pq.isEmpty() || i<n){

            if (pq.isEmpty() && timer < arr[i][0]) { timer = arr[i][0]; }

            while (i < n && arr[i][0] <= timer) { pq.offer(arr[i]); i++; }


            int[] temp = pq.poll();
            result[idx++] = temp[2];
            timer += temp[1];
        }

        return result;
        
    }
}