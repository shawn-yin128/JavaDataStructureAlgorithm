package DataStructure.Tree.BST;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * In a binary search tree, find k nodes containing the closest numbers to the given target number. return them in sorted array
 */
public class ClosetNumberII {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    public int[] closet(TreeNode root, double target, int k) {
        if (root == null) {
            return new int[] {};
        }
        Deque<Integer> sw = new ArrayDeque<>();
        helper(root, target, k, sw);
        int size = sw.size(); // must compute size first because the size will change
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = sw.pollFirst();
        }
        return result;
    }

    private void helper(TreeNode root, double target, int k, Deque<Integer> sw) {
        if (root == null) {
            return;
        }
        helper(root.left, target, k, sw);
        if (sw.size() < k) {
            sw.offerLast(root.key);
        } else {
            if (Math.abs(root.key - target) < Math.abs(sw.peekFirst() - target)) {
                sw.pollFirst();
                sw.offerLast(root.key);
            } else {
                return;
            }
        }
        helper(root.right, target, k, sw);
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */
