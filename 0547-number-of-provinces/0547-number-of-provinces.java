class Solution {
    public int findCircleNum(int[][] isConnected) {
       int v = isConnected.length;
        int count = 0;   // initialize count properly

        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {   // start from 0
            if (!vis[i]) {
                count++;
                dfshelper(i, vis, isConnected);
            }
        }
        return count;   // no need count++
    }

     public void dfshelper(int node, boolean[] vis,int[][] isConnected){
        
       vis[node] = true;

        // traverse all neighbours (matrix form)
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[node][j] == 1 && !vis[j]) {
                dfshelper(j, vis, isConnected);
            }
        }
    }
}