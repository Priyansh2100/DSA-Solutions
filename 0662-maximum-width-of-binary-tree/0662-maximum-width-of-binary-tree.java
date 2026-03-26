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
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int currLevelSize = q.size();
            int stIdx = q.peek().getValue();
            int endIdx = q.peek().getValue();

            for (int i = 0; i < currLevelSize; i++) {
                Pair<TreeNode, Integer> curr = q.poll();
                TreeNode node = curr.getKey();
                int idx = curr.getValue();
                endIdx = idx;

                if (node.left != null) {
                    q.offer(new Pair<>(node.left, idx * 2 + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair<>(node.right, idx * 2 + 2));
                }
            }

            maxWidth = Math.max(maxWidth, endIdx - stIdx + 1);
        }

        return maxWidth;
    }
}
