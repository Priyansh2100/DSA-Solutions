class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

      List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]); // undirected graph
        }

        // visited array
        boolean[] vis = new boolean[n];

        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (curr == destination) {
                return true; // path found
            }

            for (int nei : graph.get(curr)) {
                if (!vis[nei]) {
                    q.add(nei);
                    vis[nei] = true;
                }
            }
        }

        return false; // no path exists
}
}