package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * create by ljs on 2020/7/22 16:23
 * description:
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 *
 * 分析： 一共需要 k 层梦境到底， 每一层有 n 个选择； 但是为了去重，去掉重复的分支； 选择为 n - level 个选择。
 *
 */
public class Combine_77 {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>(k);

        if ( k > n ) {
            return result;
        }
        int start = 1, level = 0;
        helper(n, k, start, level, path, result);
        return result;
    }

    // 可以减少level参数；判断 path 的大小，如果是k，递归结束
    private void helper(int n, int k, int start, int level, List<Integer> path, List<List<Integer>> result) {

        if ( level == k ) {
            result.add(new ArrayList<>(path));
            return;
        }

        for ( int i = start; i <= n; ++i ) { // 当层的选择范围为 【start,n】
            path.add(i);
            helper(n,k, i + 1, level+1,path, result );
            path.remove(path.size()-1);
        }
    }


}
