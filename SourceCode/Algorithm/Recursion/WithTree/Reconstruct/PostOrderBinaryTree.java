package Algorithm.Recursion.WithTree.Reconstruct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.
 */
public class PostOrderBinaryTree {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value) {
            key = value;
        }
    }

    public TreeNode reconstructBST(int[] post) {
        if (post == null) {
            return null;
        }
        int[] in = Arrays.copyOf(post, post.length);
        Arrays.sort(in);
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            index.put(in[i], i);
        }
        return helper(post, index, 0, in.length - 1, 0, post.length - 1);
    }

    private TreeNode helper(int[] post, Map<Integer, Integer> index, int inLeft, int inRight, int postLeft, int postRight) {
        if (postLeft > postRight) {
            return null;
        }
        TreeNode root = new TreeNode(post[postRight]);
        int idx = index.get(root.key);
        root.left = helper(post, index, inLeft, idx - 1, postLeft, postLeft + idx - inLeft - 1);
        root.right = helper(post, index, idx + 1, inRight, postLeft + idx - inLeft, postRight - 1);
        return root;
    }
}

/**
 * time complexity: O(nlogn)
 * space complexity: O(height)
 */