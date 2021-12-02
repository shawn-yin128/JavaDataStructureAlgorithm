package Algorithm.Recursion.WithTree;

import DataStructure.Tree.CommonBinaryTree.AdvancedTreeRecursion.ClosetNumberII;

/**
 * Given a binary tree in which each node contains an integer number. Find the maximum possible path sum from a leaf to root.
 */
public class MaxPathLeafToRoot {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    // bottom up
    public int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.key;
        }
        if (root.left == null) {
            return maxPath(root.right) + root.key;
        } else if (root.right == null) {
            return maxPath(root.left) + root.key;
        } else {
            return Math.max(maxPath(root.left), maxPath(root.right)) + root.key;
        }
    }

    // top down
    public int maxPath(TreeNode root, int sum) {
        sum += root.key;
        if (root.left == null && root.right == null) {
            return sum;
        }
        if (root.left == null) {
            return maxPath(root.right, sum);
        } else if (root.right == null) {
            return maxPath(root.left, sum);
        } else {
            return Math.max(maxPath(root.left, sum), maxPath(root.right, sum));
        }
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */