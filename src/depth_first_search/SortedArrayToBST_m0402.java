package depth_first_search;

import binarytree.TreeNode;

/**
 * create by ljs on 2020/7/15 19:19
 * description:
 */
public class SortedArrayToBST_m0402 {


    public TreeNode sortedArrayToBST(int[] nums) {

        return dfs(nums, 0, nums.length-1);


    }

    private TreeNode dfs(int[] nums, int left, int right) {

        if ( left > right ) {
            return null;
        }

        int mid = (left+right) >> 1;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = dfs(nums, left, mid-1);
        node.right = dfs(nums, mid+1, right);

        return node;
    }


}
