package DataStructure.Tree.BST.Advanced;

/**
 * Given two keys in a binary search tree, find their lowest common ancestor.
 */
public class BSTLCA {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    public TreeNode LCA(TreeNode root, int one, int two) {
        if (root == null) {
            return root;
        }
        int small = Math.min(one, two);
        int large = Math.max(one, two);
        while (root != null) {
            if (root.key < small) {
                root = root.right;
            } else if (root.key > large) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */