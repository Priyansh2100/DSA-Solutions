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

    // Helper function to get the height of the tree
    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Left to Right
    public void nthLevel(TreeNode root, int n, List<Integer> arr) {
        if (root == null) return;
        if (n == 1) {
            arr.add(root.val);
            return;
        }
        nthLevel(root.left, n - 1, arr);
        nthLevel(root.right, n - 1, arr);
    }

    // Right to Left
    public void nthLevel2(TreeNode root, int n, List<Integer> arr) {
        if (root == null) return;
        if (n == 1) {
            arr.add(root.val);
            return;
        }
        nthLevel2(root.right, n - 1, arr);
        nthLevel2(root.left, n - 1, arr);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int level = height(root);
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        for (int i = 1; i <= level; i++) {
            List<Integer> arr = new ArrayList<>();
            if (i % 2 != 0) {
                nthLevel(root, i, arr);    // Odd level: left to right
            } else {
                nthLevel2(root, i, arr);   // Even level: right to left
            }
            ans.add(arr);
        }
        return ans;
    }
}
