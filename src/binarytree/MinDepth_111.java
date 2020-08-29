package binarytree;

import java.util.LinkedList;

/**
 * create by ljs on 2020/6/24 18:37
 * <p>
 * description:  求这个数的最小到叶子的最小深度。
 *
 *  注意：到叶子，树的深度。
 *
 *              3
 *        null     5
 *               4   null
 *
 *     深度优先搜索；
 *
 *     广度优先搜索：  效率应该是最高的。
 */
public class MinDepth_111 {


    public int minDepth01(TreeNode root) {

            if ( root == null ) {
                return 0;
            }

            if ( root.left == null && root.right != null ) {
                return minDepth01(root.right) + 1;
            }

            if ( root.right == null && root.left != null ) {
                return minDepth01(root.left) + 1;
            }

            return Math.min(minDepth01(root.left), minDepth01(root.right)) + 1;

    }

    // 这个写法； 没有第一种好。
    public int minDepth02(TreeNode root) {

        if (root == null)
            return 0;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if ( root.left != null )
            left = minDepth02(root.left);
        if ( root.right != null )
            right = minDepth02(root.right);

        // 判断两者中的最小值。
        int min = Math.min(left, right) != Integer.MAX_VALUE ? Math.min(left, right) :0;

        return min + 1;

    }

    // 深度优先搜索。 这个来说是比较好的；代码简洁
    public int minDepth(TreeNode root) {

        if ( root == null )
            return 0;
        if ( root.left == null && root.right == null ) {  // 这个是叶子节点
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if ( root.left != null ) { // 存在左子树
            min_depth = Math.min(minDepth(root.left),min_depth);
        }
        if ( root.right != null ) { // 存在右子树
            min_depth = Math.min(minDepth(root.right),min_depth);
        }
        return min_depth + 1;
    }

    // todo 广度优先搜索。  查找最短的。
    public int minDepth03(TreeNode root) {

        if ( root == null )
            return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while ( !queue.isEmpty() ) {

            int size = queue.size();
            depth++;
            for ( int i = 0; i < size; ++i ) {
                TreeNode node = queue.poll();
                if ( node.left == null && node.right == null )
                    return depth;
                if ( node.left != null )
                    queue.add(node.left);
                if ( node.right != null )
                    queue.add(node.right);
            }
        }
        return depth;
    }
}