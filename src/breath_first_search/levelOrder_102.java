package breath_first_search;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * create by ljs on 2020/7/17 19:54
 * description:
 */
public class levelOrder_102 {


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if ( root != null )
            queue.offer(root);

        while ( !queue.isEmpty() ) {

            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for ( int i=0; i < size; ++i ) {

                TreeNode node = queue.poll();
                level.add(node.val);
                if ( node.left != null )
                    queue.offer(node.left);
                if ( node.right != null )
                    queue.offer(node.right);
            }

            result.add(level); // 添加一层。

        }

        return result;
    }



}
