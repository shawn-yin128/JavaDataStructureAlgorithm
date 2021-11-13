package Algorithm.Recursion.WithTree;

/**
 * Given two nodes in a binary tree, find their lowest common ancestor.
 * There is no parent pointer for the nodes in the binary tree
 * The given two nodes are guaranteed to be in the binary tree
 */
public class LowestCommonAncestorI {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null) {
            return null;
        }
        if (root == one || root == two) {
            return root;
        }
        TreeNode left = LCA(root.left, one, two);
        TreeNode right = LCA(root.right, one, two);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */
