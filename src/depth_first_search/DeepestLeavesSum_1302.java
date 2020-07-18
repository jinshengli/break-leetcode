package depth_first_search;

import binarytree.TreeNode;

import java.util.LinkedList;

/**
 * create by ljs on 2020/7/15 19:32
 * description:
 *
 *  1302. 层数最深叶子节点的和
 *
 *
 *  第一次想到层次遍历； 求出最后一层的叶子的值之和。
 *
 */
public class DeepestLeavesSum_1302 {

    /**
     *  层次遍历
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if ( root == null )
            return 0;
        queue.offer(root);
        while ( !queue.isEmpty() ) {
            // 遍历某一层的节点、
            int size = queue.size();
            ans = 0;
            for (int i = 0; i < size; i++ ) {
                TreeNode node = queue.poll();
                ans += node.val;
                if ( node.left != null )
                    queue.offer(node.left);
                if ( node.right != null )
                    queue.offer(node.right);
            }
        }
        return ans;
    }


    /**
     *      dfs ： 需要记录最深的叶子的深度、 和值。
     * @param root
     * @return
     */

    private int maxDepth;
    private int result;

    public int deepestLeavesSum01(TreeNode root) {

        maxDepth = Integer.MIN_VALUE;
        result = 0;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {

        if ( root == null )
            return;

        if ( root.left == null  && root.right == null ) {
            if ( level > maxDepth ) {
                maxDepth = level;
                result = root.val;
            } else if ( level == maxDepth ) {
                result += root.val;
            }
        }

        dfs(root.left, level+1);
        dfs(root.right, level+1);

    }


    public static void main(String[] args) {


        LinkedList<Integer> queue = new LinkedList<>();

        queue.push(1);
        queue.push(2);  // 栈的方法； 队列头添加。

        queue.add(3);
        queue.add(4);

        queue.offer(6);
        queue.offer(7);

        while ( !queue.isEmpty() ) {

            Integer poll = queue.poll();
            System.out.println(poll);

            Integer pop = queue.pop();
            System.out.println(pop);

        }



    }


}
