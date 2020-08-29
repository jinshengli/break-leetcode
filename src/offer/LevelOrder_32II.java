package offer;

import binarytree.TreeNode;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class LevelOrder_32II {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if ( root == null )
            return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while ( !queue.isEmpty() ) {

            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for ( int i = 0; i < size; ++i ) {
                TreeNode poll = queue.poll();
                level.add(poll.val);
                if ( poll.left != null )
                    queue.add(poll.left);
                if ( poll.right != null )
                    queue.add(poll.right);
            }
            result.add(level);
        }
        return result;
    }

}
