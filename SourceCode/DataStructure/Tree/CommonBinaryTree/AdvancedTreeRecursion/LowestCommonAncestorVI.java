package DataStructure.Tree.CommonBinaryTree.AdvancedTreeRecursion;

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
    
}
