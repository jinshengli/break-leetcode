package depth_first_search;

import binarytree.TreeNode;


/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的
 */
public class IsSameTree_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 不符合题目要求。写成异构也返回true了。
     */
    public boolean isSameTree01(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        TreeNode pLeft = p.left;
        TreeNode qLeft = q.left;

        TreeNode pRight = p.right;
        TreeNode qRight = q.right;

        if (pLeft == null && qLeft == null) {
            return isSameTree(pRight, qRight);
        }

        if (pLeft == null && qRight == null) {
            return isSameTree(pRight, qLeft);
        }

        if (pRight == null && qRight == null) {
            return isSameTree(pLeft, qLeft);
        }

        if (pRight == null && qLeft == null) {
            return isSameTree(pLeft, qRight);
        }

        if (pLeft.val == qLeft.val) {
            return isSameTree(pLeft, qLeft) && isSameTree(pRight, qRight);
        } else {
            return isSameTree(pLeft, qRight) && isSameTree(pRight, qLeft);
        }
    }

}
