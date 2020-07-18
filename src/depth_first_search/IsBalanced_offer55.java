package depth_first_search;

import binarytree.TreeNode;

/**
 * create by ljs on 2020/7/15 16:36
 * description:
 *
 *  判断给定的二叉树是不是平衡二叉树； 左右子树的深度相差不超过1
 *
 *
 *  定义一个不是二叉树的返回条件 -1
 *
 *  后序遍历；先求出它的左右子树。
 *
 *
 */
public class IsBalanced_offer55 {

    public boolean isBalanced(TreeNode root) {

        return dfs(root) != -1;

    }

    private int dfs(TreeNode root) {

        if ( root == null )
            return 0;

        int ldepth = dfs(root.left);
        int rdepth = dfs(root.right);

        if ( ldepth == -1 || rdepth == -1 )
            return -1;

        if ( Math.abs(ldepth-rdepth) > 1 ) {
            return -1;
        }

        return Math.max(ldepth, rdepth)+1;
    }


}
