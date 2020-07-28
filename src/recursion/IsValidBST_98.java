package recursion;

import binarytree.TreeNode;

/**
 * create by ljs on 2020/7/23 19:22
 * description:
 *
 *  给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 */
public class IsValidBST_98 {

        // 不知道该方法为啥错。
//    public boolean isValidBST(TreeNode root) {
//
//        if ( root == null || root.left == null && root.right == null ) {
//            return true;
//        }
//        if ( !isValidBST(root.left) ) {
//            return false;
//        }
//        if ( !isValidBST(root.right) ) {
//            return false;
//        }
//
//        if ( root.left != null  && root.right != null ) {
//            int l = root.left.val;
//            int r = root.right.val;
//            return l <= root.val && root.val <= r ? true : false;
//        } else if ( root.right == null && root.left != null ) {
//            return root.left.val <= root.val ? true:false;
//        } else {
//            return root.val <= root.right.val ? true:false;
//        }
//    }

    private long pre = Long.MIN_VALUE; // 防止溢出

    public boolean isValidBST(TreeNode root) {

        if ( root == null )
            return true;
        if ( !isValidBST(root.left) ) {
            return false;
        }
        if ( pre >= root.val ) // 注意需要等于
            return false;
        pre = root.val;
        return isValidBST(root.right);
    }

    public boolean isValidBST01(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer low, Integer top) {
        if ( root == null )
            return true;
        int val = root.val;
        if ( top != null && top <= val ) return false; // 定义上界
        if ( low != null && low >= val ) return false;
        return helper(root.left, low, val) && helper(root.right, val, top);
    }


}
