package dynamic_programming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * create by ljs on 2020/8/7 14:23
 * description:
 *
 *
 *  剑指 Offer 42. 连续子数组的最大和
 *
 *  输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 *  dp[n] 是 0 ~ n 个位置的数 的子数组的和的最大值、
 *
 *  n = 0; dp[n] = nums[n];
 *
 *  dp[n] =
 *            dp[n-1] + nums[n] ; dp[n-1] >= 0
 *            nums[n]             dp[n-1] < 0
 *
 *
 */
public class MaxSubArray_f42 {

    public int maxSubArray(int[] nums) {

        if ( nums == null || nums.length == 0 ) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];

        dp[0] = nums[0];
        for ( int i = 1; i < length; ++ i ) {
            dp[i] = dp[i-1] < 0 ? nums[i] : dp[i-1] + nums[i];
        }

        int result = dp[0];
        for ( int i = 0; i < length; ++i ) {
            result = Math.max(result,dp[i]);
        }
        return result;
    }

}
