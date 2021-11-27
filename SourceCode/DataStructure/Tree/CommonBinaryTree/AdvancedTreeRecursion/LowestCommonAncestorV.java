package DataStructure.Tree.CommonBinaryTree.AdvancedTreeRecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two nodes in a K-nary tree, find their lowest common ancestor.
 */
public class LowestCommonAncestorV {
    public static class KnaryTreeNode {
        int key;
        List<KnaryTreeNode> children;

        public KnaryTreeNode(int key) {
            this.key = key;
            this.children = new ArrayList<>();
        }
    }

    public KnaryTreeNode LCA(KnaryTreeNode root, KnaryTreeNode one, KnaryTreeNode two) {
        if (root == null) {
            return null;
        }
        return helper(root, one, two);
    }

    private KnaryTreeNode helper(KnaryTreeNode root, KnaryTreeNode one, KnaryTreeNode two) {
        if (root == null) {
            return null;
        }
        if (root == one || root == two) {
            return root;
        }
        KnaryTreeNode result = null;
        for (KnaryTreeNode node : root.children) {
            KnaryTreeNode lca = helper(node, one, two);
            if (lca == null) {
                continue;
            } else {
                if (result == null) {
                    result = lca;
                } else {
                    return root;
                }
            }
        }
        return result;
    }
}
