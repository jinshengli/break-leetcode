package prefix_and;

import java.util.HashMap;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 *
 */

public class SubarraySum_560 {

    // 暴力枚举 O(n^2)
    public int subarraySum01(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            int sum = 0;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // 前缀和 + hashMap. O(n) + O(n*log(n))
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


}
