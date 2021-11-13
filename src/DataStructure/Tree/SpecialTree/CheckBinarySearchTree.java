package DataStructure.Tree.SpecialTree;

public class CheckBinarySearchTree {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
    }

    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.key <= min || root.key >= max) {
            return false;
        }
        return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */