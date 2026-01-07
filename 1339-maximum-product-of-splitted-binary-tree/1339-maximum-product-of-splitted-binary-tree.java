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

    long totalSUM = 0;
    long maxP = 0;
    static final int MOD = 1_000_000_007;

    //totalSum method
    public long totalSum(TreeNode root){
        if(root ==null){
            return 0;
        }
        return root.val + totalSum(root.left) + totalSum(root.right);
    }

    public long find(TreeNode root){
        if(root == null){
            return 0;
        }
        long leftSum  = find(root.left);
        long rightSum = find(root.right);
        long  subtreeSum = root.val + leftSum + rightSum;

        long remainingSum = totalSUM - subtreeSum;

        maxP = Math.max(maxP, subtreeSum*remainingSum);

        return subtreeSum;
        
    }
    public int maxProduct(TreeNode root) {
        if(root == null){
            return 0;
        }
        totalSUM = totalSum(root);
        find(root);
        return (int)(maxP % MOD);

        
    }
}