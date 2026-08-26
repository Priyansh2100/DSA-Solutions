class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        // phale current code se no of path nikal liya
        int count = noOfPath(root, targetSum);
        
        //ab hum har node le liye, path nikal rhe h 
        count += pathSum(root.left, targetSum) + pathSum(root.right, targetSum);

        return count;
    }

    private int noOfPath(TreeNode root, long targetSum) {

        if (root == null) {
            return 0;
        }
        int count = 0;

        if ((long) root.val == targetSum) {
            count++;
        }

        return count + noOfPath(root.right,targetSum - root.val) + noOfPath(root.left,targetSum - root.val);
    }
}