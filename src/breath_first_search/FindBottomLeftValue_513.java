package breath_first_search;

import binarytree.TreeNode;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * create by ljs on 2020/7/30 20:55
 * description:
 *
 * 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 *  bfs： 最后一层第一个数。
 *
 */
public class FindBottomLeftValue_513 {

    public int findBottomLeftValue(TreeNode root) {

        if ( root == null ) {
            throw new IllegalArgumentException("非法参数");
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = root.val;
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            result = queue.peek().val;
            for ( int i = 0; i < size; ++i ) {
                TreeNode treeNode = queue.poll();
                if ( treeNode.left != null ) queue.add(treeNode.left);
                if ( treeNode.right != null ) queue.add(treeNode.right);
            }
        }
        return result;
    }
}
