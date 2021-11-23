package DataStructure.Tree.CommonBinaryTree.BasicOperation.Traverse;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Get the list of keys in a given binary tree layer by layer in zig-zag order.
 */
public class ZigZagTraverseBinaryTree {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
    }

    public List<Integer> zigzagTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerFirst(root);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                if (level % 2 == 1) {
                    TreeNode cur = q.pollLast();
                    result.add(cur.key);
                    if (cur.right != null) {
                        q.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        q.offerFirst(cur.left);
                    }
                } else {
                    TreeNode cur = q.pollFirst();
                    result.add(cur.key);
                    if (cur.left != null) {
                        q.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        q.offerLast(cur.right);
                    }
                }
            }
            level++;
        }
        return result;
    }
}
