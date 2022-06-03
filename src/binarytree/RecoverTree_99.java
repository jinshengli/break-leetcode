package binarytree;


/**
 * 99. 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 */
public class RecoverTree_99 {

    TreeNode x = null;
    TreeNode y = null;
    TreeNode pre = null;


    /**
     * TODO 栈的模式 中序遍历
     * @param root
     */
    public void recoverTree(TreeNode root) {
        recover(root);
        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }



    public void recoverTree01(TreeNode root) {
        recover(root);
        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    /**
     * 中序遍历。
     */
    private void recover(TreeNode root) {
        if (root != null) {
            recover(root.left);
            if (pre != null && pre.val > root.val) {   // take pre point. it is important
                if (x == null) x = pre;
                y = root;
            }
            pre = root;
            recover(root.right);
        }
    }


}
