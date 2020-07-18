package binarytree;

/**
 * create by ljs on 2020/6/14 17:07
 * <p>
 * description:  第一一个二叉树的节点。
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x ){
        this.val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
