package DataStructure.Tree.CommonBinaryTree.BasicOperation.Traverse;

import java.util.*;

public class ThreeOrderTraverseIterative {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
    }

    public List<Integer> preOrder(TreeNode root) { // use a stack
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            resList.add(cur.key);
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
        }
        return resList;
    } /* time complexity: O(n) space complexity: O(n+height) if only print it will be O(height) since max is the longest all right node */

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                resList.add(cur.key);
                cur = cur.right;
            }
        }
        return resList;
    } /* time complexity: O(n) space complexity: O(n+height) if only print it will be O(height) since max is the longest all right node */

    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            if (prev == null || cur == prev.left || cur == prev.right) {
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    stack.pollFirst();
                    result.add(cur.key);
                }
            } else if (prev == cur.right || (prev == cur.left && cur.right == null)) { // if no right node, add cur which is root in this case to result
                stack.pollFirst();
                result.add(cur.key);
            } else {
                stack.offerFirst(cur.right);
            }
            prev = cur;
        }
        return result;
    } /* time complexity: O(n) space complexity: O(n+height) if only print it will be O(height) since max is the longest all right node */
}
