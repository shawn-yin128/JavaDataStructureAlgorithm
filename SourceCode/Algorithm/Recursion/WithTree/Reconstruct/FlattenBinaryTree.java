package Algorithm.Recursion.WithTree.Reconstruct;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * from right ro left. the right most is the the tail and then the left of it and move up.
 */
public class FlattenBinaryTree {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    public TreeNode flatten(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode[] prev = new TreeNode[1];
        helper(root, prev);
        return root;
    }

    private void helper(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return;
        }
        helper(root.right, prev);
        helper(root.left, prev);
        root.right = prev[0];
        root.left = null;
        prev[0] = root;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */