package Algorithm.Recursion.WithTree;

/**
 * Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any node
 * the start node and the end node can be the same.
 */
public class MaxPathSumII {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] result = new int[] {Integer.MIN_VALUE};
        helper(root, result);
        return result[0];
    }

    private int helper(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, result);
        int right = helper(root.right, result);
        left = left > 0 ? left : 0;
        right = right > 0 ? right : 0;
        result[0] = Math.max(left + right + root.key, result[0]);
        return Math.max(left, right) + root.key;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */