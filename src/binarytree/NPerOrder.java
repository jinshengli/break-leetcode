package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * create by ljs on 2020/6/14 18:46
 * <p>
 * description:
 */
public class NPerOrder {


    public List<Integer> preorder(Node root) {

        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list;


    }

    public void helper( List<Integer> list, Node root ) {

        if ( root != null ){

            list.add(root.val);
            for (Node child : root.children) {
                if ( child != null )
                    helper(list, child);
            }

        }

    }



}
