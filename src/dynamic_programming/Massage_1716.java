package dynamic_programming;

/**
 * create by ljs on 2020/8/7 17:42
 * description:
 *
 *      面试题 17.16. 按摩师
 *
 *      输入： [1,2,3,1]
     * 输出： 4
     * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4
 *
 *      dp[i][0]: 代表在 【0，i】的预约范围内，不选择i 次预约的最长时间
 *      dp[i][1]: 代表在【0，i】的预约范围内，选择i次预约的最长时间
 *
 *      转态状态方程：
 *
 *          dp[i][0] = max {dp[i-1][0], dp[i-1][1]} 前天没有预约 和 前天预约了
 *          dp[i][1] = dp[i-1][0] + nums[i];
 *      base:
 *          dp[0][0] = 0
 *          dp[0][1] = nums[0]
 *
 *
 *  可以改为滚动数组。
 *
 */
public class Massage_1716 {

    // 二维数据
    public int massage(int[] nums) {

        if ( nums == null || nums.length == 0 ) {
            return -1;
        }
        if ( nums.length == 1 ) {
            return nums[0];
        }

        int len = nums.length;
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for ( int i = 1; i < len; ++i ) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];

        }
        return Math.max(dp[len-1][0], dp[len-1][1]);
    }
}
