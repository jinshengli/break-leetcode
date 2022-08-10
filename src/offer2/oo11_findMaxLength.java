package offer2;


import java.util.HashMap;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 示例 2：
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 *
 *
 * 1 <= nums.length <= 10^5
 * nums[i] 不是 0 就是 1
 */
public class oo11_findMaxLength {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n+1];
        for (int i = 1; i <= n; ++i) {
            int b = nums[i-1] == 0 ? -1 : 1;
            preSum[i] = preSum[i-1] + b;
        }

        // find preSum[i] - preSum[j] = 0;  j - i 长度最长
        // pre preSum[j]... preSum[i] == preSum[j]  j < i
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (map.containsKey(preSum[i])) {
                int index = map.get(preSum[i]);
                ans = Math.max(ans, i - index);
            } else {
                map.put(preSum[i], i);
            }
        }
        return ans;
    }
}
