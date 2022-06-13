package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 081. 允许重复选择元素的组合
 *
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，
 * 找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 *
 *
 */
public class CombinationSum_081 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates, target, 0, 0, path, ans);
        return ans;
    }

    private void helper(int[] candidates, int target, int sum, int start, List<Integer> path, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            if (sum + candidates[i] > target) {
                continue;
            }
            path.add(candidates[i]);
            helper(candidates, target, sum + candidates[i], i, path, ans);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum_081 combinationSum_081 = new CombinationSum_081();
        int nums[] = {2,3,6,7};
        List<List<Integer>> lists = combinationSum_081.combinationSum(nums, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
