import java.util.*;

class Solution {

    Map<TreeNode, TreeNode> parent = new HashMap<>();

    // Step 1: Store parent of each node
    public void addParent(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            parent.put(root.left, root);
            addParent(root.left);
        }

        if (root.right != null) {
            parent.put(root.right, root);
            addParent(root.right);
        }
    }

    // Step 2: BFS from target
    public List<Integer> collectKDistanceNodes(TreeNode target, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (k == 0) break;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // left
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.offer(curr.left);
                    visited.add(curr.left);
                }

                // right
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.offer(curr.right);
                    visited.add(curr.right);
                }

                // parent
                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    queue.offer(parent.get(curr));
                    visited.add(parent.get(curr));
                }
            }
            k--;
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        addParent(root);
        return collectKDistanceNodes(target, k);
    }
}