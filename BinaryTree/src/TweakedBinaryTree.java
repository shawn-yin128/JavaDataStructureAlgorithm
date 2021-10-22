/**
 * check whether a tree is identical with allowed tweak (swap of children of one node)
 */
public class TweakedBinaryTree {
    public boolean isTweaked(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }
        return (isTweaked(one.left, two.left) && isTweaked(one.right, two.right)) || (isTweaked(one.left, two.right) && isTweaked(one.right, two.left));
    }
}

/**
 * time complexity: O(n^2)
 * space complexity: O(height)
 */
