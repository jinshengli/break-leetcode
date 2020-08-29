package binarytree;

/**
 * create by ljs on 2020/8/17 15:45
 * description:
 *  110. 平衡二叉树
 *
 *  给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 *
 */
public class isBalanced_110 {


    /**
     *  从顶向下遍历不是最优解。 计算了很多重复的内容。
     * @param root
     * @return
     */
    public boolean isBalanced01(TreeNode root) {

        if ( root == null ) {
            return true;
        }

        return Math.abs(heigth(root.left) - heigth(root.right) ) <= 1 && isBalanced01(root.left) && isBalanced01(root.right);

    }

    private int heigth(TreeNode root) {

        if ( root == null )
            return 0;

        return Math.max(heigth(root.left), heigth(root.right)) + 1;
    }


    public boolean isBalanced(TreeNode root) {

        return helper(root) >= 0;

    }

    private int helper(TreeNode root) {

        if ( root == null )
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        if ( left == -1 || right == -1 || Math.abs(left-right) > 1 )
            return -1;
        return Math.max(left, right) + 1;
    }


}
