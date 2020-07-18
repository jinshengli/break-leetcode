package binarytree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * create by ljs on 2020/6/14 17:10
 * <p>
 * description: 中序遍历一棵树
 */
public class InorderTraversalTree_94 {


    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list;

    }


    public void helper( List<Integer> list,  TreeNode root ) {

        if ( root != null ){

            if ( root.left != null )
                helper(list, root.left);
            list.add(root.val);
            if ( root.right != null )
                helper(list, root.right);

        }
    }


    public List<Integer> inorderTraversalByStack(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;

        /**
         *  cur 代表当前遍历节点的位置，并且还没加入到栈中、
         *
         *  cur 会遍历树上的每一个节点，遍历之后加入到栈中。
         *
         *
         */
        while ( cur != null || !stack.isEmpty() ) {

            while ( cur != null ){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;

    }





}
