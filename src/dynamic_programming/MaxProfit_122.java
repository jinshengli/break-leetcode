package dynamic_programming;


/**
 * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润。

 *
 */
public class MaxProfit_122 {


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // dp[i][0] 第i天不持有股票的收益
        // dp[i][1] 第i天不持有股票的收益
        int [][]dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
        }

        return dp[prices.length-1][0];
    }

    /**
     * 贪心，一天中发现有利益就交易一次。
     *
     * @param prices
     * @return
     */
    public int maxProfit01(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i] < prices[i+1]) {
                profit += (prices[i+1] - prices[i]);
            }
        }
        return profit;
    }
}
