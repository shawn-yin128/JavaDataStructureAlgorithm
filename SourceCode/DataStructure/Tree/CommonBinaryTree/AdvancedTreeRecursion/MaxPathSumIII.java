package DataStructure.Tree.CommonBinaryTree.AdvancedTreeRecursion;

/**
 * Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum
 * both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the subpath is allowed to contain only one node.
 */
public class MaxPathSumIII {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] result= new int[] {Integer.MIN_VALUE};
        helper(root, result);
        return result[0];
    }

    private int helper(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, result);
        int right = helper(root.right, result);
        int cur = Math.max(Math.max(left, right), 0) + root.key;
        result[0] = Math.max(result[0], cur);
        return cur;
    }
}

/***
 * time complexity: O(n)
 * space complexity: O(height)
 */