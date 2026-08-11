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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        preOrder(root, arr);
        return arr;
    }

    void preOrder(TreeNode curr, ArrayList<Integer> arr) {
        if (curr == null) {
            return;
        }
        arr.add(curr.val);
        preOrder(curr.left, arr);
        preOrder(curr.right, arr);
    }
}