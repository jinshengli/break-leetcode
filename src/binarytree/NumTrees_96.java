package binarytree;


import java.util.HashMap;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class NumTrees_96 {

    HashMap<Integer, Integer> cntMap = new HashMap<>();
    public int numTrees(int n) {
        int ans = 0;
        if (n == 0 || n == 1) {
            return 1;
        }
        if (cntMap.containsKey(n)) {
            return cntMap.get(n);
        }
        for (int i = 1; i <= n; ++i) {
            ans += numTrees(i - 1) * numTrees(n - i);
        }
        cntMap.put(n, ans);
        return ans;
    }

    public int numTrees01(int n) {
        int ans = 0;
        if (n == 0 || n == 1) {
            return 1;
        }
        for (int i = 1; i <= n; ++i) {
            ans += numTrees01(i - 1) * numTrees01(n - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        NumTrees_96 test = new NumTrees_96();
        System.out.println(test.numTrees(10));
    }
}
