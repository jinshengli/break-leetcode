package dynamic_programming;

/**
 * create by ljs on 2020/8/12 12:17
 * description:     523. 连续的子数组和
 *
 *  给定一个包含 非负数 的数组和一个目标 整数 k，
 *  编写一个函数来判断该数组是否含有连续的子数组，
 *  其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，
 *  其中 n 也是一个整数。
 *
 *
 *  dp[n] = dp[n-1] + nums[n];
 *
 *  dp[n] 代表从 [0...n]之间的和；
 *
 *
 *
 */
public class CheckSubarraySum_523 {

    public boolean checkSubarraySum(int[] nums, int k) {

        if ( nums == null || nums.length < 2 ) {
            return false;
        }

        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        for ( int i = 1; i < len; ++i ) {
            dp[i] = dp[i-1] + nums[i];
        }
        for ( int i = 0; i < len-1; i ++ ) {
            for ( int j = i+1; j < len; ++j ) {
                int sum = dp[j] - dp[i] + nums[i];
                if ( k == 0 ) {
                    // k == 0 ; 连续的子数组都为 0
                    if ( sum == 0 )
                    return true;
                } else {
                    if ( sum % k == 0 )
                        return true;
                }
            }
        }

        return false;

    }


    // 代码优化上一版
    public boolean checkSubarraySum01(int[] nums, int k) {

        if ( nums == null || nums.length < 2 ) {
            return false;
        }

        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        for ( int i = 1; i < len; ++i ) {
            dp[i] = dp[i-1] + nums[i];
        }
        for ( int i = 0; i < len-1; i ++ ) {
            for ( int j = i+1; j < len; ++j ) {
                int sum = dp[j] - dp[i] + nums[i];
                if ( sum == k || k != 0 && sum % k == 0 )
                    return true;
            }
        }

        return false;

    }


}
