package DataStructure.Tree.CommonBinaryTree.AdvancedTreeRecursion.PathSumToTarget;

/**
 * Given a binary tree and a target sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given target.
 */
public class PathSumToTargetI {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    public boolean sumToTarget(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        return helper(root, 0, target);
    }

    private boolean helper(TreeNode root, int sum, int target) {
        sum += root.key;
        if (root.left == null && root.right == null) {
            if (sum == target) {
                return true;
            }
            return false;
        }
        if (root.left == null) {
            return helper(root.right, sum, target);
        } else if (root.right == null) {
            return helper(root.left, sum, target);
        } else {
            return helper(root.left, sum, target) || helper(root.right, sum, target);
        }
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */