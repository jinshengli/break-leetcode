package recursion;

import binarytree.TreeNode;

/**
 * create by ljs on 2020/7/23 19:17
 * description:
 *
 *  226. 翻转二叉树
 */
public class InvertTree_226 {


    public TreeNode invertTree(TreeNode root) {

        if ( root == null ) {
            return null;
        }

        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }


}
