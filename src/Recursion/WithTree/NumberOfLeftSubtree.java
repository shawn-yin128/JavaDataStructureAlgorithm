package WithTree;

/**
 * Given a binary tree, count the number of nodes in each node’s left subtree, and store it in the numNodesLeft field.
 */
public class NumberOfLeftSubtree {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public int numNodesLeft;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public int numberLeft(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = numberLeft(root.left);
        int right = numberLeft(root.right);
        root.numNodesLeft = left;
        return (left + right + 1);
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */