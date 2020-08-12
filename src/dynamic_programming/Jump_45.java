package dynamic_programming;

import java.util.Arrays;

/**
 * create by ljs on 2020/8/10 23:38
 * description:
 *      45. 跳跃游戏 II
 *
 *      给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置
 */
public class Jump_45 {


    /**
     *      dp[n] = min{dp[i] + 1};
     *              if i in (0..n-1) and i + nums[i] >= nums.length
     *
     *      dp[n] 是跳跃到当前位置所需的最小次数
     * @param nums
     * @return
     */

    public int jump(int[] nums) {

        if ( nums == null || nums.length == 0 )
            return 0;

        int len = nums.length;
        int[] dp = new int[len];

        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] = 0;

        for ( int i = 0; i < len; ++i ) {
            for ( int j = 1; j <= nums[i]; ++j ) {
                if ( dp[i] != Integer.MAX_VALUE && (i+j) < len ) {
                    dp[i+j] = Math.min(dp[i+j], dp[i] + 1);
                } else {
                    break;
                }
            }
        }
        return dp[len-1];
    }

}
