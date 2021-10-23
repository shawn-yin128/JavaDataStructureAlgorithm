import java.util.List;

/**
 * get keys from certain range in a BST
 */
public class GetKeyInRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {

    }

    public List<Integer> getRange(TreeNode root, int min, int max, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.key > min) {
            getRange(root.left, min, max, list);
        }
        if (root.key >= min && root.key <= max) {
            list.add(root.key);
        }
        if (root.key < max) {
            getRange(root.right, min, max, list);
        }
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */