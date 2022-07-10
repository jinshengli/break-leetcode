package weeken.w0709;

import binarytree.TreeNode;


/**
 * 给你一棵 完整二叉树 的根，这棵树有以下特征：
 *
 * 叶子节点 要么值为 0 要么值为 1 ，其中 0 表示 False ，1 表示 True 。
 * 非叶子节点 要么值为 2 要么值为 3 ，其中 2 表示逻辑或 OR ，3 表示逻辑与 AND 。
 *
 *
 */
public class EvaluateTree {

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1 ? true : false;
        }

        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}
