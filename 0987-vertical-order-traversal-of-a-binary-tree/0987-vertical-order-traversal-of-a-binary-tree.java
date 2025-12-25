/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    static class Pair {
        TreeNode node;
        int col;
        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map to store column index to list of node values
        Map<Integer, List<Integer>> map = new TreeMap<>();
        // Queue for BFS: stores node and its column index
        Queue<Pair> q = new LinkedList<>();

        if (root == null) return new ArrayList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            // For each level, use a temporary map to collect nodes at the same position
            Map<Integer, List<Integer>> temp = new HashMap<>();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                TreeNode node = p.node;
                int col = p.col;

               if (!temp.containsKey(col)) {
    temp.put(col, new ArrayList<>());
}
temp.get(col).add(node.val);

                if (node.left != null) q.add(new Pair(node.left, col - 1));
                if (node.right != null) q.add(new Pair(node.right, col + 1));
            }
            // For each column, add sorted values to the main map
            for (int col : temp.keySet()) {
                List<Integer> list = temp.get(col);
                Collections.sort(list); // sort for same row, left to right
                map.computeIfAbsent(col, k -> new ArrayList<>()).addAll(list); // hum add kar rhe h , map global aceassable h ye 
            }
        }

        // Build result
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> colList : map.values()) {
            result.add(colList);
        }
        return result;
    }
}