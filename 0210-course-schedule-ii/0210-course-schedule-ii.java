import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Calculate indegree for each course
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course); // prereq -> course
            indegree[course]++;
        }

        // Step 3: Add all courses with indegree = 0 to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 4: BFS + Topological Sort
        int[] result = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int curr = q.remove();
            result[idx++] = curr;

            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Step 5: Check if topological sort is possible
        if (idx == numCourses) {
            return result;
        } else {
            return new int[0]; // cycle detected
        }
    }
}
