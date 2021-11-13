package DataStructure.Tree.CommonBinaryTree.BasicOperation.Traverse;

public class ThreeOrderTraverse {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.key);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.key);
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.key);
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */