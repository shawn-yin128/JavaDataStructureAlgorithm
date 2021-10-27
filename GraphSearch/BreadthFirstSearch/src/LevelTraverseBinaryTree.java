import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelTraverseBinaryTree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLayer = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curLayer.add(cur.key);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            result.add(curLayer);
        }
        return result;
    }
}
