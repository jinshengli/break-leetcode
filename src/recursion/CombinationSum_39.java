package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * create by ljs on 2020/7/22 15:12
 * description:
 *
 *  [[2,2,3],[2,3,2],[3,2,2],[7]]  问题1： 需要对结果进行去重。
 *
 *
 *  给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if ( candidates == null )
            return result;

        helper(candidates, target, 0, 0, path, result);
        return result;
    }

    private void helper(int[] candidates, int target, int start, int sum,
                        List<Integer> path, List<List<Integer>> result) {
        // 加上start 是为了去重，减少重复的分支。
        if ( sum > target )
            return;
        if ( sum == target ) {
            result.add(new ArrayList<>(path));
        }

        for ( int i = start; i < candidates.length; ++i ) {
            if ( sum + candidates[i] > target )
                continue;
            path.add(candidates[i]);
            helper(candidates, target, i, sum+candidates[i], path, result);
            path.remove(path.size()-1); // 回溯
        }


    }

//    // 这个helper没有去重；
//    private void helper(int[] candidates, int target, int sum, List<Integer> path, List<List<Integer>> result) {
//
//        if ( sum > target ) { // 路径上的和超出了目标值
//            return;
//        }
//        if ( sum == target ) { // 找到了一组结果
//            result.add(new ArrayList<>(path));
//        }
//        for ( int i = 0; i < candidates.length; ++i ) {
//            if ( sum + candidates[i] > target ) // 超出预期
//                continue;
//            path.add(candidates[i]);
//            helper(candidates, target, sum+candidates[i], path, result);
//            // 回溯
//            path.remove(path.size()-1);
//        }
//    }


}
