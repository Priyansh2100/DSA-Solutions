
class Solution {

    public int find(TreeNode root,int curr){
        if(root == null) return 0;

        curr = curr * 10 + root.val;

        if(root.left == null && root.right == null) return curr;

        int left = find(root.left,curr);
        int right = find(root.right,curr);

        return left + right;
    }
    public int sumNumbers(TreeNode root) {
        return find(root,0);
    }
}