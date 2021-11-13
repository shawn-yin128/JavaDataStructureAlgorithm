package Algorithm.GraphSearch.BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class CheckCompleteTree {
    public static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
    }

    public boolean checkComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.left);
            }
            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */