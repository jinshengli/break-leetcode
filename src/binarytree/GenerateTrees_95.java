package binarytree;


import binarysearch.GenerateMatrix_59;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 */
public class GenerateTrees_95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> ans = new ArrayList<>();
        if (left > right) {
            ans.add(null);
            return ans;
        }
        for (int k = left; k <= right; ++k) {
            List<TreeNode> leftRootList = dfs(left, k - 1);
            List<TreeNode> rightRootList = dfs(k + 1, right);
            for (TreeNode leftNode : leftRootList) {
                for (TreeNode rightNode : rightRootList) {
                    TreeNode cur = new TreeNode(k);
                    cur.left = leftNode;
                    cur.right = rightNode;
                    ans.add(cur);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GenerateTrees_95 test = new GenerateTrees_95();
        List<TreeNode> treeNodes = test.generateTrees(3);
    }
}
