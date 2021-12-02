package DataStructure.Tree.CommonBinaryTree.AdvancedTreeRecursion.PathSumToTarget;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a binary tree in which each node contains an integer number.
 * Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), the sum of the numbers on the path is the given target number.
 */
public class PathSumToTargetIII {
    public class TreeNode {
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
        Set<Integer> preSum = new HashSet<>();
        preSum.add(0);
        return helper(root, target, 0, preSum);
    }

    private boolean helper(TreeNode root, int target, int sum, Set<Integer> preSum) {
        sum += root.key;
        if (preSum.contains(sum - target)) {
            return true;
        }
        boolean curAdd = preSum.add(sum);
        if (root.left != null && helper(root.left, target, sum, preSum)) {
            return true;
        }
        if (root.right != null && helper(root.right, target, sum, preSum)) {
            return true;
        }
        if (curAdd) {
            preSum.remove(sum);
        }
        return false;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */