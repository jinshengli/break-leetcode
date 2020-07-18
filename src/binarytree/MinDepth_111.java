package binarytree;

/**
 * create by ljs on 2020/6/24 18:37
 * <p>
 * description:  求这个数的最小到叶子的最小深度。
 *
 *  注意：到叶子，树的深度。
 *
 */
public class MinDepth_111 {


    public int minDepth(TreeNode root) {

            if ( root == null ) {
                return 0;
            }

            if ( root.left == null && root.right != null ) {
                return minDepth(root.right) + 1;
            }

            if ( root.right == null && root.left != null ) {
                return minDepth(root.left) + 1;
            }

            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

    }

}