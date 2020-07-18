package recursion;

import binarytree.TreeNode;

/**
 * create by ljs on 2020/6/14 20:35
 * <p>
 * description:
 */
public class ValidBST_98 {

    private int last = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if ( root != null ){
            if ( !isValidBST(root.left) ){
                return false;
            }
            if ( last >= root.val )
                return false;
            last = root.val;
            return isValidBST(root.right);
        }
        return true;
    }
}
