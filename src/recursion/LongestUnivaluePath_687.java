package recursion;

import binarytree.TreeNode;

/**
 * create by ljs on 2020/7/25 20:31
 * description:
 *
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 *
 *           2
 *
 *
 */
public class LongestUnivaluePath_687 {

    private Integer result;
    public int longestUnivaluePath(TreeNode root) {
        result = 0;
        helper(root);
        return result;
    }
    private int helper(TreeNode root) {
        if ( root == null )
            return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int left =0, right = 0;
        if ( root.left != null && root.left.val == root.val ) {
            left = l + 1;
        }
        if ( root.right != null && root.right.val == root.val ) {
            right = r + 1;
        }
        result = Math.max(result, right+left);
        return Math.max(left, right);
    }


}
