
class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        
        for (int i = 1; i < inorderList.size(); i++) {
            if (inorderList.get(i) <= inorderList.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}