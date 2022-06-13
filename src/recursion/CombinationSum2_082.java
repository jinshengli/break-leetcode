package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 082. 含有重复元素集合的组合
 * 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 *
 */

public class CombinationSum2_082 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, 0, path, ans);
        return ans;
    }

    private void helper(int[] candidates, int target, int sum, int start, List<Integer> path, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            // 后面的分支都不满足要求
            if (sum + candidates[i] > target) {
                return;
            }
            // 去重, 当前层不能有重复选择相同的值的元素。
            if (i > start && candidates[i-1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            helper(candidates, target, sum + candidates[i], i +1, path, ans);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2_082 combinationSum2_082 = new CombinationSum2_082();
        int []nums = {10,1,2,7,6,1,5};

        List<List<Integer>> lists = combinationSum2_082.combinationSum2(nums, 8);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
