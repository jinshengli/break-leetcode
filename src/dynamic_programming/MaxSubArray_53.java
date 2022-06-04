package dynamic_programming;


/**
 *
 * 53. 最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 */
public class MaxSubArray_53 {


    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; ++i) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(ans, pre);
        }
        return ans;
    }

    /**
     * 第一次朴素动态规划
     *
     * @param nums
     * @return
     */
    public int maxSubArray01(int[] nums) {
        int len = nums.length;
        int []dp = new int[len];
        int ans = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < len; ++i) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


}
