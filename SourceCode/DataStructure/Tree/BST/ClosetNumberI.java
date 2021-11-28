package DataStructure.Tree.BST;

/**
 * In a binary search tree, find the node containing the closest number to the given target number.
 */
public class ClosetNumberI {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    public int closet(TreeNode root, int target) {
        int result = root.key;
        while (root != null) {
            if (root.key == target) {
                return root.key;
            } else {
                if (Math.abs(root.key - target) < Math.abs(result - target)) {
                    result = root.key;
                }
                if (root.key < target) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
        return result;
    }
}

/**
 * time complexity: O(height)
 * space complexity: O(1)
 */