package TreeBasicOperation;

/**
 * Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left leaf nodes as the root.
 */
public class ReverseUpsideDown {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    public TreeNode reverse(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = reverse(root.left);
        root.left.right = root.right;
        root.left.left = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */
