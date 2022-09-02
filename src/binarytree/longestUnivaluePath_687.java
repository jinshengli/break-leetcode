package binarytree;


/**
 * 687. 最长同值路径
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 *
 * 两个节点之间的路径长度 由它们之间的边数表示。
 *
 */
public class longestUnivaluePath_687 {

    private int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int l = 0; int r = 0; // 在如果跟的值和他左右节点值不同时，初始值
        if (root.left != null && root.left.val == root.val) {
            l = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            r = right + 1;
        }
        ans = Math.max(ans, l + r);
        return Math.max(l, r);
    }
}
