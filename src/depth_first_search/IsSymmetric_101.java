package depth_first_search;

import binarytree.TreeNode;


/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 对称二叉树
 */
public class IsSymmetric_101 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricSolution(root, root);
    }

    private boolean isSymmetricSolution(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null) {
            return true;
        }

        if (root == null || root1 == null) {
            return false;
        }

        if (root.val != root1.val) {
            return false;
        }

        return isSymmetricSolution(root.left, root1.right) && isSymmetricSolution(root.right, root1.left);

    }
}
