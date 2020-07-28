package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * create by ljs on 2020/7/23 20:21
 * description:
 *
 *  给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 *
 *  todo 需要定义一个是否被visited的 标记
 *
 *
 */
public class Permute_46 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean []visited = new boolean[nums.length];
        helper(0, path, result, nums, visited);
        return result;
    }

    private void helper(int level,List<Integer> path,
                        List<List<Integer>> result, int[] nums, boolean visited[]) {

        if ( level == nums.length ) {
            result.add(new ArrayList<>(path));
            return;
        }

        for ( int i = 0; i < nums.length; ++i ) { // 到达下一层也是从0开始选择，因为有visited判重了。
            if ( visited[i]  )
                continue;
            path.add(nums[i]);
            visited[i] = true;
            helper(level+1, path, result, nums, visited);
            path.remove(path.size()-1);
            visited[i] = false;  // 回溯
        }
    }

}
