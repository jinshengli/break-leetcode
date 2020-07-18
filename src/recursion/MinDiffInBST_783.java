package recursion;

import binarytree.TreeNode;

/**
 * create by ljs on 2020/7/15 13:19
 * description:
 *
 *  783. 二叉搜索树节点最小距离
 *
 */
public class MinDiffInBST_783 {

    private int minDiff;      // 树中任意两节点的差的最小值。
    private TreeNode preNode;     // 中序遍历中，前一个节点.

    public int minDiffInBST(TreeNode root) {

        minDiff = Integer.MAX_VALUE;
        preNode = null;
        dfs(root);
        return minDiff;

    }

    private void dfs(TreeNode root) {

        if ( root == null )
            return;
        dfs(root.left);
        if ( preNode != null ) {
            minDiff = Math.min(minDiff, root.val- preNode.val);
        }
        preNode = root;
        dfs(root.right);
    }

}
