package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * create by ljs on 2020/6/14 17:48
 * <p>
 * description: 前序遍历二叉树； 根 - 左 - 右
 */
public class PreOrderTraversalTree_144 {


    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list;
    }


    public void helper( List<Integer> res, TreeNode root ) {

        if ( root != null ){
            res.add(root.val);
            if ( root.left != null )
                helper(res, root.left);
            if ( root.right != null )
                helper(res, root.right);
        }

    }


    public List<Integer> preorderTraversalByStack(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while ( cur != null || !stack.isEmpty() ){

            while ( cur != null ){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }


        return list;
    }



}
