package Algorithm.Recursion.WithTree.MaxPathSum;

/**
 * Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf node to another leaf node.
 * If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).
 */
public class MaxPathSumI {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        helper(root, result);
        return result[0];
    }

    private int helper(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.key;
        }
        int left = helper(root.left, result);
        int right = helper(root.right, result);
        if (root.left != null && root.right != null) {
            int curSum = left + right + root.key;
            result[0] = Math.max(result[0], curSum);
            return Math.max(left, right) + root.key;
        } else if (root.left == null) {
            return right + root.key;
        } else {
            return left + root.key;
        }
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */