package dynamic_programming;

/**
 * create by ljs on 2020/8/7 20:53
 * description:
 *
 *  122. 买卖股票的最佳时机 II
 *
 *  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *  和 第一题的区别： 交易次数不固定。
 *
 *  dp[i][0] 第i天没持有股票，最大的收益、
 *  dp[i][1] 第i天持有股票，最大的收益。
 *
 *  dp[i][0] = max( dp[i-1][0], dp[i-1][1] + prices[i]  )
 *  dp[i][1] = max( dp[i-1][1], dp[i-1][0] - prices[i] )
 *
 *  base:
 *
 *      dp[0][0] = 0;
 *      dp[0][1] = -prices[0]
 *
 *  1 <= prices.length <= 3 * 10 ^ 4
 *  0 <= prices[i] <= 10 ^ 4
 *
 */
public class MaxProfit_392 {


    public int maxProfit(int[] prices) {

        if ( prices == null || prices.length <= 1 ) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for ( int i = 1; i < len; ++i ) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return dp[len][0];
    }

}
