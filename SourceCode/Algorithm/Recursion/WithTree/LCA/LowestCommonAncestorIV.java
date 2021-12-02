package Algorithm.Recursion.WithTree.LCA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given K nodes in a binary tree, find their lowest common ancestor
 */
public class LowestCommonAncestorIV {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    public TreeNode LCA(TreeNode root, List<TreeNode> list) {
        if (root == null || list == null) {
            return null;
        }
        Set<TreeNode> set = new HashSet<>(list);
        return helper(root, set);
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> set) {
        if (root == null) {
            return null;
        }
        if (set.contains(root)) {
            return root;
        }
        TreeNode left = helper(root.left, set);
        TreeNode right = helper(root.right, set);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height + k) k is the size of list because we new a set of that list
 */