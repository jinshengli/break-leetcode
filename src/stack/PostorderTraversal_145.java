package stack;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * create by ljs on 2020/7/11 20:46
 * description:
 *
 *  145. 二叉树的后序遍历
 */
public class PostorderTraversal_145 {


    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        postOrderBinaryTree(root, result);

        return result;

    }

    private void postOrderBinaryTree(TreeNode root, List<Integer> result) {

        if ( root == null ) {
            return;
        }

        postOrderBinaryTree(root.left, result);
        postOrderBinaryTree(root.right, result);

        result.add(root.val);

    }


}
