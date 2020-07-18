package recursion;

import binarytree.TreeNode;

/**
 * create by ljs on 2020/7/15 11:31
 * description:
 *
 *      938. 二叉搜索树的范围和
 *
 *   题目： 前提，二叉搜索树，值唯一。
 *
 *         节点值为 [L,R] 范围内的和。
 *
 *
 */
public class RangeSumBST_938 {

    /**
        第一版，没有优化
     */
    public int rangeSumBST(TreeNode root, int L, int R) {

        if ( root == null ) {
            return 0;
        }

        int l = rangeSumBST(root.left, L, R);
        int r = rangeSumBST(root.right, L, R);
        int res = l + r;
        if ( root.val >= L && root.val <= R ) {
            res += root.val;
        }
        return res;

    }

    private int ans = 0;

    public int rangeSumBST01(TreeNode root, int L, int R) {

        ans = 0;
        dfs(root,L, R);
        return ans;
    }

    private void dfs(TreeNode root, int l, int r) {

        if ( root == null ) {
            return;
        }

        if ( l <= root.val && root.val <= r ) {
            ans += root.val;
        }

        if ( l < root.val ) { //
            dfs(root.left, l, r);
        }

        if ( root.val < r ) {
            dfs(root.right, l, r);
        }
    }


}
