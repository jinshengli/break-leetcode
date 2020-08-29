package offer;

import binarytree.TreeNode;

/**
 * create by ljs on 2020/8/1 17:28
 * description:
 *
 *  请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class MirrorTree_27 {

    public TreeNode mirrorTree(TreeNode root) {

        if ( root == null )
            return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }


}
