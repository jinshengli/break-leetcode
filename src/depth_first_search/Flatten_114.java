package depth_first_search;

import binarytree.TreeNode;

import java.util.LinkedList;

/**
 * create by ljs on 2020/7/15 20:17
 * description:
 *
 *  114. 二叉树展开为链表
 */
public class Flatten_114 {

    /**
     *   先序遍历； 链表保存每个treenode； 效率低
     * @param root
     */

    public void flatten01(TreeNode root) {

        LinkedList<TreeNode> list = new LinkedList<>();
        dfs(root, list);
        setRightTree(list);
    }

    private void setRightTree(LinkedList<TreeNode> list) {

        for ( int i = 0; i < list.size()-1; ++i ) {
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }
    }

    private void dfs(TreeNode root, LinkedList<TreeNode> list) {
        if ( root == null )
            return;
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }


    /**
     *
     * @param root
     */
    public void flatten(TreeNode root) {

        if ( root == null ) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if ( root.left != null ) {
            TreeNode tmp = root.right;
            TreeNode pre = root.left;
            while ( pre.right != null )
                pre = pre.right;
            root.right = root.left;
            root.left = null;
            pre.right = tmp;
        }
    }

}
