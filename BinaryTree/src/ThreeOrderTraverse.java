/**
 * class TreeNode {
 *     public int value;
 *     public TreeNode left;
 *     public TreeNode right;
 * }
 */

public class ThreeOrderTraverse {
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */