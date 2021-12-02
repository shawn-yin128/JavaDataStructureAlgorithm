package Algorithm.Recursion.WithTree.LCA;

/**
 * Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).
 * Return null If any of the nodes is not in the tree.
 */
public class LowestCommonAncestorIII {
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
        TreeNode result = helper(root, one, two);
        if (result != one && result != two) {
            return result;
        } else if (result == one) {
            if (isFind(one, two)) {
                return result;
            }
        } else if (result == two) {
            if (isFind(two, one)) {
                return result;
            }
        }
        return null;
    }

    private TreeNode helper(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null) {
            return null;
        }
        if (root == one || root == two) {
            return root;
        }
        TreeNode left = helper(root.left, one, two);
        TreeNode right = helper(root.right, one, two);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    private boolean isFind(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        boolean left = isFind(root.left, node);
        boolean right = isFind(root.right, node);
        return left || right;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */