import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ThreeOrderTraverseIterative {
    public List<Integer> preOrder(TreeNode root) { // use a stack
        if (root == null) {
            return new LinkedList<Integer>();
        }
        List<Integer> resList = new LinkedList<>();
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
        List<Integer> resList = new LinkedList<>();
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

    }
}
