package offer;

import binarytree.TreeNode;

/**
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 * @author ljs
 * @since 2021/8/30 下午9:42
 **/
public class IsSymmetric_28 {

    public boolean isSymmetric(TreeNode root) {

        return checkIsSame(root, root);

    }

    private boolean checkIsSame(TreeNode root, TreeNode root1) {
        if (root == null || root1 == null) {
            return root == root1;
        }
        if (root.val != root1.val) {
            return false;
        }

        return checkIsSame(root.left, root1.right) && checkIsSame(root.right, root1.left);

    }
}
