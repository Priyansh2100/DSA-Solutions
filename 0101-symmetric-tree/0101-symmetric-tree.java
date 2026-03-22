class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        // invert left subtree
        TreeNode invertedLeft = invertTree(root.left);

        // compare with right subtree
        return isSameTree(invertedLeft, root.right);
    }
}