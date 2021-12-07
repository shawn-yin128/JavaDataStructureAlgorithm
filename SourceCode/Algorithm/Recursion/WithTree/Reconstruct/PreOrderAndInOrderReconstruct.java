package Algorithm.Recursion.WithTree.Reconstruct;

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

    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        Map<Integer, Integer> index = getIndex(inOrder);
        return helper(index, preOrder, 0, inOrder.length - 1, 0, preOrder.length - 1);
    }

    private Map<Integer, Integer> getIndex(int[] inOrder) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            index.put(inOrder[i], i);
        }
        return index;
    }

    private TreeNode helper(Map<Integer, Integer> inOrder, int[] preOrder, int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode curRoot = new TreeNode(preOrder[preLeft]);
        int idx = inOrder.get(curRoot.key);
        curRoot.left = helper(inOrder, preOrder, inLeft, idx - 1, preLeft + 1, preLeft + idx - inLeft);
        curRoot.right = helper(inOrder, preOrder, idx + 1, inRight, preLeft + 1 + idx - inLeft, preRight);
        return curRoot;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(height)
 */