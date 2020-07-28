package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * create by ljs on 2020/7/24 20:50
 * description:
 *
 *      216. 组合总和 III
 *
 *      找出所有相加之和为 n 的 k 个数的组合。
 *      组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 *      // todo 总结一波组合
 *
 */
public class CombinationSum3 {


    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(1, k, n, 0, path, result);
        return result;
    }

    private void helper(int start, int k, int n, int sum,
                        List<Integer> path, List<List<Integer>> result) {

        if ( path.size() == k  && sum == n ) {
            result.add(new ArrayList<>(path));
            return;
        }

        if ( sum >= n ) {
            return;
        }

        for ( int i = start; i <= 9; ++i ) {
            path.add(i);
            helper(i+1, k, n,sum+i, path, result);
            path.remove(path.size()-1);
        }
    }

}
