package offer2;


import java.util.HashMap;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 * 示例 2：
 *
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 *
 */
public class oo10_subarraySum {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n+1];
        for (int i = 1; i <= n; ++i) {
            preSum[i] += preSum[i-1] + nums[i-1];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            int start = preSum[i] - k;
            if (map.containsKey(start)) {
                ans += map.get(start);
            }
            int orDefault = map.getOrDefault(preSum[i], 0);
            map.put(preSum[i], orDefault+1);
        }
        return ans;
    }
}
