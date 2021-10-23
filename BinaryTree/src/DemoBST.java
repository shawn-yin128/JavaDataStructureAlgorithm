public class DemoBST {
    public TreeNode search(TreeNode root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (root.key > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (root.key > key) {
            root.left = insert(root.left, key);
        } else if (root.key < key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.key == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            } else {
                TreeNode newRoot = small(root.right);
                newRoot.left = root.left;
                newRoot.right = root.right;
                return newRoot;
            }
        }
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        }
        return root;
    }

    private TreeNode small(TreeNode root) {
        while (root.left.left != null) {
            root = root.left;
        }
        TreeNode smallest = root.left;
        root.left = root.left.right;
        return smallest;
    }
}
