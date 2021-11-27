package Algorithm.Recursion.WithTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given M nodes in a K-nary tree, find their lowest common ancestor.
 */
public class LowestCommonAncestorVI {
    public static class KnaryTreeNode {
        int key;
        List<KnaryTreeNode> children;

        public KnaryTreeNode(int key) {
            this.key = key;
            this.children = new ArrayList<>();
        }
    }

    public KnaryTreeNode LCA(KnaryTreeNode root, List<KnaryTreeNode> list) {
        Set<KnaryTreeNode> set = new HashSet<>(list);
        return helper(root, set);
    }

    private KnaryTreeNode helper(KnaryTreeNode root, Set<KnaryTreeNode> set) {
        if (root == null) {
            return null;
        }
        if (set.contains(root)) {
            return root;
        }
        KnaryTreeNode result = null;
        for (KnaryTreeNode node : root.children) {
            KnaryTreeNode lca = helper(node, set);
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
