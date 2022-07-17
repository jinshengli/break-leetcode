package depth_first_search;

import java.util.Arrays;

/**
 * 565. 数组嵌套
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 *
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 *
 *
 * N是[1, 20,000]之间的整数。
 * A中不含有重复的元素。
 * A中的元素大小在[0, N-1]之间。
 *
 */
public class ArrayNesting_565 {

    public int arrayNesting(int[] nums) {
        if (nums.length == 0) return 0;
        boolean[] vis = new boolean[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            // Arrays.fill(vis, false);
            if (vis[i] == false) {
                ans = Math.max(ans, dfs(nums, vis, i));
            }
        }
        return ans;
    }

    private int dfs(int[] nums, boolean[] vis, int i) {
        vis[nums[i]] = true;
        int count = 1;
        int next = nums[nums[i]];
        if (vis[next] == false) {
            count += dfs(nums,  vis, nums[i]);
        }
        return count;
    }

}
