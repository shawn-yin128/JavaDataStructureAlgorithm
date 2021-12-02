package DataStructure.Tree.CommonBinaryTree.AdvancedTreeRecursion.LCA;

/**
 * Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.
 */
public class LowestCommonAncestorII {
    public static class TreeNodeP {
        public int key;
        public TreeNodeP left;
        public TreeNodeP right;
        public TreeNodeP parent;
        public TreeNodeP(int value, TreeNodeP parent) {
            key = value;
            this.parent = parent;
        }
    }

    public TreeNodeP LCA(TreeNodeP one, TreeNodeP two) {
        int oneLength = findHeight(one);
        int twoLength = findHeight(two);
        if (oneLength > twoLength) {
            return LCAHelper(two, one, oneLength - twoLength);
        } else {
            return LCAHelper(one, two, twoLength - oneLength);
        }
    }

    private TreeNodeP LCAHelper(TreeNodeP shorter, TreeNodeP longer, int diff) {
        while (diff > 0) {
            shorter = shorter.parent;
            diff--;
        }
        while (shorter != null && longer != null) {
            if (shorter == longer) {
                return longer;
            }
            shorter = shorter.parent;
            longer = longer.parent;
        }
        return null;
    }

    private int findHeight(TreeNodeP root) {
        int length = 0;
        while (root != null) {
            root = root.parent;
            length++;
        }
        return length;
    }
}

/**
 * time complexity: O(height)
 * space complexity: O(1)
 */