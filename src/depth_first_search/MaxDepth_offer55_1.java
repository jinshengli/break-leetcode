package depth_first_search;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * create by ljs on 2020/7/15 16:46
 * description:
 *
 *  剑指 Offer 55 - I. 二叉树的深度
 *
 *  跟节点到叶子节点的最大距离
 *
 *
 *
 *
 */
public class MaxDepth_offer55_1 {


    /**
     *  dfs 的解法；
     *
     *  后序遍历； 求出左右子树的高度l,r; max(l,r) + 1
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {

        if ( root == null )
            return 0;

        if ( root.left == null && root.right == null ) { // 到达叶节点
            return 1;
        }
        int depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return depth;
    }


    /**
     *  使用层次遍历；   这么写层次遍历会产生很多中间队列；
     * @param root
     * @return
     */

    public int maxDepthBFS(TreeNode root ) {

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if ( root == null ) {
            return 0;
        }
        queue.add(root);
        while ( !queue.isEmpty() ) {
            LinkedList<TreeNode> tmp = new LinkedList<>();
            for (TreeNode treeNode : queue) {
                if ( treeNode.left != null )
                    tmp.add(treeNode.left);
                if ( treeNode.right != null )
                    tmp.add(treeNode.right);
            }
            // 可以抛弃原来的队列了， 使用这个临时队列
            queue = tmp;
            depth++;
        }
        return depth;

    }

    /**
     *  改进版 层次遍历
     * @param root
     * @return
     */
    public int maxDepthBFS01(TreeNode root ) {
        int depth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if ( root == null ) {
            return 0;
        }
        queue.add(root);
        while ( !queue.isEmpty() ) {
            //  遍历的这层元素个数
            int n = queue.size();
            for ( int i = 0; i < n; ++i ) {
                TreeNode poll = queue.poll();
                if ( poll.left != null )
                    queue.add(poll.left);
                if ( poll.right != null )
                    queue.add(poll.right);
            }
            depth++;
        }
        return depth;

    }



}
