package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 *
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 *
 * 1 <= n <= 5 * 104
 */

public class LexicalOrder_386 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; ++i) {
            dfs(n, ans, i);
        }
        return ans;
    }

    private void dfs(int n, List<Integer> ans, int num) {
        if (num > n) {
            return;
        }
        ans.add(num);
        for (int i = 0; i < 10; ++i) {
            dfs(n, ans, num*10 + i);
        }
    }

    public static void main(String[] args) {
        LexicalOrder_386 test = new LexicalOrder_386();
        List<Integer> integers = test.lexicalOrder(10);
        System.out.println(integers);
    }
}
