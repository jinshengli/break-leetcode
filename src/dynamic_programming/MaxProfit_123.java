package dynamic_programming;

/**
 * create by ljs on 2020/8/7 22:19
 * description:
 *
 *  123. 买卖股票的最佳时机 III
 *
 *  给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格.
 *  设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易
 *
 *  卖出之后才能再次买入
 *
 *
 *
 *
 */
public class MaxProfit_123 {


    public int maxProfit(int[] prices) {

        // dp[i][k][0]: 代表第（i-1）天结束，经过最多交易k次，手上不持有股票的最大收益
        // dp[i][k][1]: 代表第（i-1）天结束，经过最多交易k次，手上持有股票的最大收益

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int [][][]dp = new int[len][3][2];

        dp[0][0][0] = 0;
        dp[0][0][1] = 0;  // 没用到
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];

        // 买入和卖出才算一次交易。这里定义在买入的时候算一次交易。
        for (int i = 1; i < len; ++i) {
             dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i]);
             dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][0] - prices[i]);
             dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][2][1] + prices[i]);
             dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][1][0] - prices[i]);
        }

        return dp[len-1][2][0];

    }
}
