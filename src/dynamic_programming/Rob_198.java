package dynamic_programming;

/**
 * create by ljs on 2020/8/3 23:15
 * description:
 *
 *  198. 打家劫舍
 *
 *  ，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，
 * 一夜之内能够偷窃到的最高金额。
 *
 *
 *  从 0 偷到 i-1 位置的房子所代表的 最大金额。 偷i间房子的最大金额
 *
 * i 位置； 选择
 *      偷 or 不偷
 *
 * 偷 i ： dp[i] = dp[i-2] + nums[i]
 * 不偷 i：dp[i] = dp[i-1]
 *
 *
 *
 * ---> dp[i] = max(dp[i-2]+nums[i], dp[i-1])
 *
 */
public class Rob_198 {

    public int rob(int[] nums) {

        if ( nums == null || nums.length == 0 )
            return 0;


        int length = nums.length;

        int[] dp = new int[length+1];
        dp[0] = 0;
        dp[1] = nums[0];

        for ( int i = 2; i <= length; ++i ) {
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        return dp[length];
    }

    /**
     *      dp[i][0] 状态定义： max of robbind A[0 -> i] 且没偷 nums[i]
     *      dp[i][1] 状态定义： max of robbing A[0 -> i] 且偷了 nums[i]
     *
     *      dp[i][0] = max(dp[i-1][0], dp[i-1][1]);
     *      dp[i][1] = dp[i-1][0] + nums[i];
     *
     * @param nums
     * @return
     */
    public int rob01(int[] nums) {

        if ( nums == null || nums.length == 0 )
            return 0;


        int length = nums.length;

        int[] dp = new int[length+1];
        dp[0] = 0;
        dp[1] = nums[0];

        for ( int i = 2; i <= length; ++i ) {
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        return dp[length];
    }

}
