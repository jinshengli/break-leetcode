package sort;


import java.util.Arrays;

/**
 *
 * 532. 数组中的 k-diff 数对
 * 给你一个整数数组 nums 和一个整数 k，请你在数组中找出 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *
 * k-diff 数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
 *
 * 0 <= i, j < nums.length
 * i != j
 * nums[i] - nums[j] == k
 * 注意，|val| 表示 val 的绝对值。
 *
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个 1 ，但我们只应返回不同的数对的数量。
 *
 *
 */
public class FindPairs_532 {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; ++j) {
                if (j > i + 1 && nums[j-1] == nums[j]) {
                    continue;
                }
                if (nums[i] + k == nums[j]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }


}
