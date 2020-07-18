package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * create by ljs on 2020/6/14 18:04
 * <p>
 * description:  N 叉树的后序遍历。
 */
public class NPostOrder {


    public List<Integer> postorder(Node root) {

        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list;
    }


    public void helper( List<Integer> list, Node root ) {

        if ( root != null ){

            for (Node child : root.children) {
                if ( child != null )
                    helper(list, child);
            }

            list.add(root.val);

        }

    }


    public List<Integer> postorderByStack(Node root) {


        return null;
    }


}
