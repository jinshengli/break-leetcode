package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * create by ljs on 2020/7/23 8:43
 * description:
 *
 *  给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *
 *
 */
public class CombinationSum2_44 {



    public List<List<Integer>> combinationSum2(int[] candidates, int target) {


        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if ( candidates == null || candidates.length == 0) {
            return result;
        }
        int sum = 0;
        Arrays.sort(candidates);
        helper(candidates, sum, target, 0, path, result);
        return result;
    }

    private void helper(int[] candidates, int sum, int target, int start,
                        List<Integer> path, List<List<Integer>> result) {

        if ( sum == target ) {
            result.add(new ArrayList<>(path));
            return;
        }

        for ( int i = start; i < candidates.length; ++i ) {

            if ( sum + candidates[i] > target ) {  // 剪枝，该节点以后的元素，都不应该出现在该层。
                break;
            }
            if ( i > start && candidates[i] == candidates[i-1] ) { // 同层出现了相同的元素，剪枝
                continue;
            }
            path.add(candidates[i]);
            helper(candidates, sum+candidates[i], target, i+1, path, result);
            // 回溯
            path.remove(path.size()-1);
        }

    }


}
