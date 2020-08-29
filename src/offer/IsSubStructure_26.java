package offer;

import binarytree.TreeNode;

/**
 * create by ljs on 2020/8/1 16:55
 * description:
 *
 *  剑指 Offer 26. 树的子结构
 *
 */
public class IsSubStructure_26 {


    // 对A 树遍历进行优化
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if ( A == null || B == null )
            return false;

        return hasSubStructure(A,B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean hasSubStructure(TreeNode A, TreeNode B) {

        if ( B == null )
            return true;
        if ( A == null || A.val != B.val )
            return false;
        return hasSubStructure(A.left, B.left) && hasSubStructure(A.right, B.right);
    }


    // 未优化
    public boolean isSubStructure01(TreeNode A, TreeNode B) {


        if ( A == null || B == null )
            return false;

        boolean flag = check(A, B);
        if ( flag == false ) {
            flag = isSubStructure01(A.left, B);
            if ( flag == false )
                flag = isSubStructure01(A.right, B);
            if ( flag == true )
                return true;
        } else {
            return true;
        }

        return false;
    }

    private boolean check(TreeNode root, TreeNode B) {

        if ( B == null )
            return true;

        if ( root == null && B != null )
            return false;

        boolean l = check(root.left, B.left);
        boolean r = check(root.right, B.right);

        return l && r && root.val == B.val;

    }


}
