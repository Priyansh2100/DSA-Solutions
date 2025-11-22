import java.util.*;

class Solution {

    static class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Step 1: Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            adj.get(u).add(new Pair(v, prob));
            adj.get(v).add(new Pair(u, prob)); // UNDIRECTED GRAPH
        }

        // Step 2: Distance array (probability)
        double[] ans = new double[n];
        ans[start_node] = 1.0; // Start node probability = 1

        // Step 3: Max-Heap based on probability
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Pair(start_node, 1.0));

        // Step 4: Dijkstra’s Algorithm for maximum probability
        while (!pq.isEmpty()) {
            Pair top = pq.poll();

            // If we reach the destination, return probability
            if (top.node == end_node) {
                return top.prob;
            }

            // Skip if we already found a better probability
            if (top.prob < ans[top.node]) continue;

            // Check neighbors
            for (Pair p : adj.get(top.node)) {
                double totalProb = top.prob * p.prob;

                if (totalProb > ans[p.node]) {
                    ans[p.node] = totalProb;
                    pq.add(new Pair(p.node, totalProb));
                }
            }
        }

        return 0.0; // No path found
    }
}
