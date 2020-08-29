package offer;

import binarytree.TreeNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * [3,9,20,15,7]
 */
public class EvelOrder_32I {

    public int[] levelOrder(TreeNode root) {

        if ( root == null )
            return new int[0];

        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(root);
        while ( !queue.isEmpty() ) {
            TreeNode pop = queue.pop();
            result.add(pop.val);
            if ( pop.left != null )
                queue.add(pop.left);
            if ( pop.right != null )
                queue.add(pop.right);
        }
        int[] r = new int[result.size()];
        for ( int i = 0; i < result.size(); ++i ) {
            r[i] = result.get(i);
        }
        return r;
    }

}
