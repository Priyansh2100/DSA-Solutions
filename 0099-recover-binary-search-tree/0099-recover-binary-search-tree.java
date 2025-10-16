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
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private TreeNode prev;

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && root.val < prev.val) {
            // First violation
            if (first == null) {
                first = prev;
                middle = root;
            } 
            // Second violation
            else {
                last = root;
            }
        }

        prev = root; // mark current node as previous for next iteration
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        // Case 1: Swapped nodes are far apart
        if (first != null && last != null) {
            int t = first.val;
            first.val = last.val;
            last.val = t;
        } 
        // Case 2: Swapped nodes are adjacent in inorder
        else if (first != null && middle != null) {
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
}
