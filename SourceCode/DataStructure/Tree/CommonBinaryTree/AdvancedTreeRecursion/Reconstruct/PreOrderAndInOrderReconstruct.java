package DataStructure.Tree.CommonBinaryTree.AdvancedTreeRecursion.Reconstruct;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
 */
public class PreOrderAndInOrderReconstruct {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    // method 1
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        TreeNode root = helper(inOrder, preOrder, 0, inOrder.length - 1, 0, preOrder.length - 1);
        return root;
    }

    private TreeNode helper(int[] inOrder, int[] preOrder, int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode curRoot = new TreeNode(preOrder[preLeft]);
        int rootIdx = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (inOrder[i] == curRoot.key) {
                rootIdx = i;
                break;
            }
        }
        curRoot.left = helper(inOrder, preOrder, inLeft, rootIdx - 1, preLeft + 1, preLeft + rootIdx - inLeft);
        curRoot.right = helper(inOrder, preOrder, rootIdx + 1, inRight, preLeft + rootIdx - inLeft + 1, preRight);
        return curRoot;
    }

    // optimize
    public TreeNode reconstructII(int[] inOrder, int[] preOrder) {
        Map<Integer, Integer> index = new HashMap<>();
        index = indexMap(inOrder, index);
        TreeNode root = helperII(index, preOrder, 0, inOrder.length - 1, 0, preOrder.length - 1);
        return root;
    }

    private Map<Integer, Integer> indexMap(int[] inOrder, Map<Integer, Integer> index) {
        for (int i = 0; i < inOrder.length; i++) {
            index.put(inOrder[i], i);
        }
        return index;
    }

    private TreeNode helperII(Map<Integer, Integer> index, int[] preOrder, int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode curRoot = new TreeNode(preOrder[preLeft]);
        int rootIdx = index.get(curRoot.key);
        curRoot.left = helperII(index, preOrder, inLeft, rootIdx - 1, preLeft + 1, preLeft + rootIdx - inLeft);
        curRoot.right = helperII(index, preOrder, rootIdx + 1, inRight, preLeft + rootIdx - inLeft + 1, preRight);
        return curRoot;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */