package offer;

import binarytree.TreeNode;

import java.util.HashMap;

/**
 * create by ljs on 2020/7/28 17:43
 * description:
 *      剑指 Offer 07. 重建二叉树
 *
 *      输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 *      假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * rLR
 * LrR
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 0 <= 节点个数 <= 5000
 *
 */

public class BuildTree_07 {

    private HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if ( preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 )
            return null;
        map = new HashMap<>();

        for ( int i =0; i < inorder.length; ++i ) {
            map.put(inorder[i], i);
        }

        return buildTreeHelper0(preorder, 0, preorder.length, inorder, 0, inorder.length);

    }


    // 优化代码： 将查找中序遍历节点的顺序遍历换成 hashMap查找。
    private TreeNode buildTreeHelper0(int[] preorder, int p_start, int p_end,
                                     int[] inorder, int i_start, int i_end) {

        if ( p_start >= p_end )
            return null;

        int rootval = preorder[p_start];
        TreeNode root = new TreeNode(rootval);

        Integer k = map.get(rootval);

        int left_num = k - i_start;
        // 构建左子树。
        root.left = buildTreeHelper0(preorder, p_start+1, p_start+left_num+1, inorder, i_start, k);
        // 构建右子树。
        root.right = buildTreeHelper0(preorder, p_start+left_num+1, p_end, inorder, k+1, i_end );
        return root;
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end,
                                     int[] inorder, int i_start, int i_end) {

        if ( p_start >= p_end )
            return null;

        int rootval = preorder[p_start];
        TreeNode root = new TreeNode(rootval);

        int k = 0;
        // 找到rootval中序遍历的中的位置。
        for ( int i = i_start; i < i_end; ++i ) {
            if ( inorder[i] == rootval ){
                k = i;
                break;
            }
        }

        int left_num = k - i_start;
        // 构建左子树。
        root.left = buildTreeHelper(preorder, p_start+1, p_start+left_num+1, inorder, i_start, k);
        // 构建右子树。
        root.right = buildTreeHelper(preorder, p_start+left_num+1, p_end, inorder, k+1, i_end );
        return root;
    }



}
