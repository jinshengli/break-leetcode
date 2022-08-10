package offer2;


/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 *
 */
public class oo8_minSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int winSum = 0;
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        while (right < nums.length) {
            winSum += nums[right++];
            while (winSum >= target) {
                ans = Math.min(ans, right - left);
                winSum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // b - a >= target
    //
}
