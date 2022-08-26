package binarysearch;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * 655. 输出二叉树
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。
 * 构造此格式化布局矩阵需要遵循以下规则：
 *
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2^(height+1) - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，
 * 将其左子节点放置在 res[r+1][c-2^(height-r-1)] ，右子节点放置在 res[r+1][c+2^(height-r-1)] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 *
 *
 * 树中节点数在范围 [1, 210] 内
 * -99 <= Node.val <= 99
 * 树的深度在范围 [1, 10] 内
 *
 */
public class PrintTree_655 {

    int height = 0;
    public List<List<String>> printTree(TreeNode root) {
        height = treeHeight(root);
        int m = height + 1;
        int n = (1 << (height + 1)) - 1;
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                row.add("");
            }
            ans.add(row);
        }
        dfs(root, ans, 0, (n-1)/2);
        return ans;
    }

    private void dfs(TreeNode root, List<List<String>> ans, int x, int y) {
        ans.get(x).set(y, String.valueOf(root.val));
        int t = 1 << (height-x-1);
        if (root.left != null) {
            dfs(root.left, ans, x + 1, y - t);
        }
        if (root.right != null) {
            dfs(root.right, ans, x + 1, y + t);
        }
    }

    private int treeHeight(TreeNode root) {
        int h = 0;
        if (root.left != null) {
            h = Math.max(h, treeHeight(root.left) + 1);
        }
        if (root.right != null) {
            h = Math.max(h, treeHeight(root.right) + 1);
        }
        return h;
    }
}
