package divide_conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * create by ljs on 2020/7/8 19:13
 * description:
 *
 *          获取给定数组的所有集合
 *
 *          1. 比较简单的是遍历它的所有状态数。
 *
 */


public class Subsets_78 {


    public List<List<Integer>> subsets(int[] nums) {

        ArrayList<List<Integer>> result = new ArrayList<>();

        if ( nums.length == 0 ) {
            return result;
        }
        int index = 0;
        List<Integer> list = new ArrayList<>();

        dfs(index, list, result, nums);

        return result;

    }

    private void dfs(int index, List<Integer> list,
                     ArrayList<List<Integer>> result, int[] nums) {
        // 递归结束条件
        if ( index == nums.length  ) {
            // list 有一个子集了。
            ArrayList<Integer> a = new ArrayList<>(list);
            result.add(a);
            return;
        }
        // 该下标 数字不加入 集合
        dfs(index+1, list, result, nums);
        // 该下标 数字加入 list 集合
        list.add(nums[index]);
        dfs(index+1, list, result, nums);
        // 回溯状态

        list.remove(list.size()-1);
    }

    public static void main(String[] args) {

        Subsets_78 subsets_78 = new Subsets_78();
        int []a = {1,2,3};

        subsets_78.subsets(a);

    }


}
