package dynamic_programming;

/**
 * create by ljs on 2020/8/7 16:04
 * description:
 *
 *  746. 使用最小花费爬楼梯
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *
 *
 *  每次通过这个阶梯都需要支付 这个阶梯的费用， i + 1
 *
 * 每次可以跨一步或者两步。
 *
 * pay[n] =
 *          pay[n-1] + cost[n]
 *          pay[n-2] + cost[n]
 *
 *  两者中的最小值。
 *
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]
 */
public class MinCostClimbingStairs_746 {

    public int minCostClimbingStairs(int[] cost) {

        if ( cost == null || cost.length == 0 )
            return 0;

        int len = cost.length;
        int[] dp = new int[len+1];

        dp[0] = cost[0];
        dp[1] = cost[1];
        int pay = 0;
        for ( int i = 2; i <= len; ++i ) {
            pay = i < len ? cost[i] : 0;
            dp[i] = Math.min(dp[i-1], dp[i-2]) + pay;
        }

        return dp[len];
    }

}
