package dynamic_programming;

/**
 * create by ljs on 2020/8/7 18:51
 * description:
 *
 *  121. 买卖股票的最佳时机
 *
 *  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *
 *
 *
 *
 *
 */
public class MaxProfit_121 {


    /**
     * dp[i] 代表第i天卖出股票的最大利润。
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int len = prices.length;
        int []dp = new int[len];
        dp[0] = 0;  // 第0天卖出没任何变化
        int ans = 0;
        for (int i = 1; i < len; ++i) {
            if (prices[i] - prices[i-1] + dp[i-1] > 0) {  // 第i天股票还有利润的话。
                dp[i] = prices[i] - prices[i - 1] + dp[i - 1];
                ans = Math.max(ans, dp[i]);
            } else {
                dp[i] = 0;
            }
        }
        return ans;
    }

    // 常规方法
    public int maxProfit02(int[] prices) {

        if ( prices == null || prices.length <= 1 )
            return 0;

        int result = 0;
        int minPrices = Integer.MAX_VALUE;

        for ( int i = 0; i < prices.length; ++i ) {
            // minPrices 代表[0, i-1]区间中股票的最低价格。
            result = Math.max(result, prices[i]-minPrices); // 当前所能最大利润
            minPrices = Math.min(prices[i], minPrices);
        }

        return result;
    }

    /**
     *  动态规划：
     *
     *      dp[i][j]: 代表下标为 i 的这一天，持有或者不持有股票的最大收益，
     *
     *      dp[i][0]: 下标为 i的这一天结束时，不持有股票的情况下可以获得的最大收益
     *      dp[i][1]: 下标为 i的这一天结束时，持有股票的情况下可以获得的最大收益。
     *
     *      状态转移方程：
     *            前一天不持有股票的最大值， 前一天持有股票的最大值+第i天卖出去的价格
     *          dp[i][0] = max{dp[i-1][0],dp[i-1][1] + prices[i]}
     *
     *          // dp[i][1] = max{dp[i-1][1], dp[i-1][0] - prices[i]} 不是这样
     *              因为只进行一次操作
     *
     *             dp[i][1] = max{dp[i-1][1], -prices[i]}
     *
 *          第i天持有股票；
 *
 *         // 0：用户手上不持股所能获得的最大利润，特指卖出股票以后的不持股，非指没有进行过任何交易的不持股
 *         // 1：用户手上持股所能获得的最大利润
 *
 *         // 注意：因为题目限制只能交易一次，因此状态只可能从 1 到 0，不可能从 0 到 1
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit01(int[] prices) {

        if ( prices == null || prices.length < 2 ) {
            return 0;
        }

        int len = prices.length;
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // dp[i][0] = max{dp[i-1][0],dp[i-1][1] + prices[i]}
        // dp[i][1] = max{dp[i-1][1], -prices[i]}  最大的负数的 绝对值

        for ( int i = 1; i < len; ++i ) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }

        return dp[len-1][0];

    }




}
