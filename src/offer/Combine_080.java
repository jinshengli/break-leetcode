package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 剑指 Offer II 080. 含有 k 个元素的组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combine_080 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(n, k,1, new LinkedList<>(), ans);
        return ans;
    }

    private void helper(int n, int k, int start, LinkedList<Integer> path, List<List<Integer>> ans) {
        if (k == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; ++i) {
            path.add(i);
            helper(n, k,i + 1, path, ans);
            path.removeLast();
        }
    }

    public List<List<Integer>> combine01(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean used[] = new boolean[n+1];
        helper01(n, k, used, 1, new LinkedList<>(), ans);
        return ans;
    }

    private void helper01(int n, int k, boolean[] used, int start, LinkedList<Integer> path, List<List<Integer>> ans) {
        if (k == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; ++i) {
            if (!used[i]) {
                used[i] = true;
                path.add(i);
                helper01(n, k, used, i + 1, path, ans);
                used[i] = false;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Combine_080 combine_080 = new Combine_080();
        List<List<Integer>> combine = combine_080.combine(4, 2);

        for (List<Integer> integers : combine) {
            System.out.println(integers);
        }
    }
}
