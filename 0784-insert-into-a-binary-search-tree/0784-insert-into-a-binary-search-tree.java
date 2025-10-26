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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode ans = new TreeNode(val);
            return ans;
        }
        
        if(root.val<val){
           TreeNode ans = insertIntoBST(root.right,val);
            root.right = ans;
            return root;

        }
        if(root.val>val){
         TreeNode ans =  insertIntoBST(root.left,val);
            root.left = ans;
            return root;

        }
        return null;
    }
}