package DataStructure.Tree.SpecialTree;

public class SymmetricBinaryTree {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null || right != null) {
            return false;
        } else if (left.key != right.key) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */
