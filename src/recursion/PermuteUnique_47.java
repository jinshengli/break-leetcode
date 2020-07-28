package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * create by ljs on 2020/7/23 21:36
 * description:
 *
 *  给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 *
 *  todo 在同层之间不允许出现相同元素。 但是不同层是可以出现相同元素的。
 *
 *  nums[i] == nums[i-1] && !visited[i-1]
 *  出现相同元素意味着 会出现相同分支。
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 */
public class PermuteUnique_47 {


    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean []visited = new boolean[nums.length];
        if ( nums == null || nums.length == 0 )
            return result;
        Arrays.sort(nums);
        helper(path, visited, result, nums);

        return result;
    }

    private void helper(List<Integer> path,
                        boolean[] visited, List<List<Integer>> result, int[] nums) {

        if ( path.size() == nums.length ) {
            result.add(new ArrayList<>(path));
            return;
        }

        for ( int i = 0; i < nums.length; ++i ) {

            if ( visited[i] == true )
                continue;

//            if ( index != i && nums[index] == nums[i] ) {
//                continue;
//            }
            if ( i != 0 && nums[i] == nums[i-1] && visited[i-1] == false )
                continue;

            visited[i] = true;
            path.add(nums[i]);
            helper(path, visited, result, nums);
            // 回溯
            visited[i] = false;
            path.remove(path.size()-1);
        }
    }


}
