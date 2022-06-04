package dynamic_programming;

import binarytree.TreeNode;


/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
 *
 * 除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 *
 * 给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额。
 */
public class Rob_337 {

    public int rob(TreeNode root) {
        int []ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    /**
     * 优化代码，命名规范
     * @param root
     * @return
     */
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int []left = dfs(root.left);
        int []right = dfs(root.right);
        int noSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int selected = left[0] + right[0] + root.val;
        return new int[]{noSelected, selected};
    }

    /**
     * ans[0] 代表不抢劫root节点能获得的最大收益
     * ans[1] 代表抢劫root节点能获得的最大收益
     */
    private int[] dfs01(TreeNode root) {
        if (root == null) {
            int ans[] = new int[2];
            return  ans;
        }
        // 叶子节点
        if (root.left == null && root.right == null) {
            int ans[] = new int[2];
            ans[0] = 0;
            ans[1] = root.val;
            return ans;
        }
        int[] leftAns = dfs01(root.left);
        int[] rightAns = dfs01(root.right);
        int []ans = new int[2];
        // 不抢劫。root 下面的这一层可以抢，也可以不抢。
        ans[0] = Math.max(leftAns[0], leftAns[1]) + Math.max(rightAns[0], rightAns[1]);
        // 抢劫.  root 下面的这一层不能抢了。
        ans[1] = leftAns[0] + rightAns[0] + root.val;
        return ans;
    }

}
