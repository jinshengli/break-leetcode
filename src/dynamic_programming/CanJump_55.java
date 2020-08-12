package dynamic_programming;

import java.util.Arrays;

/**
 * create by ljs on 2020/8/10 22:04
 * description:
 *
 *  55. 跳跃游戏
 *
 *  给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * f[n] <--- f[n-i] == true? --> n - i  + nums[i] >= n+1 ? (0...n)
 *
 *
 */
public class CanJump_55 {


    /**
     *      dp[n] 代表从 n位置是否可以到达最后一个元素。 true：可以； false: 不可以。
     *
     *      dp[n]: {true,false}
     *
     *      dp[n-i]  = true && n-i + nums[i] >= n
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        if ( nums == null || nums.length == 0 )
            return false;

        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for ( int i = 0; i < dp.length; ++i ) {
            for ( int j = 1; j <= nums[i]; ++j ) {
                if ( dp[i] == true && (i + j) < dp.length ) {
                    dp[i+j] = true;
                } else {
                    break;
                }
            }
        }
        return dp[len-1];
    }


    /**
     *  贪心算法： 每次排除最大的右边范围。
     * @param nums
     * @return
     */
    public boolean canJump01(int[] nums) {

        if ( nums == null || nums.length == 0 )
            return false;

        int lastIndex = nums.length-1;
        for ( int i = nums.length-1; i >= 0; --i ) {

            if ( i + nums[i] >= lastIndex ) {
                lastIndex = i;
            }

        }

        return lastIndex == 0;

    }


}


