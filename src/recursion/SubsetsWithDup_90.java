package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class SubsetsWithDup_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        backTrace(nums, 0, path, ans);
        return ans;
    }

    private void backTrace(int[] nums, int start, LinkedList<Integer> path, List<List<Integer>> ans) {
        ans.add(new LinkedList<>(path));
        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i-1] == nums[i]) {
                continue;
            }
            path.addLast(nums[i]);
            backTrace(nums, i + 1, path, ans);
            path.removeLast();
        }
    }


}
