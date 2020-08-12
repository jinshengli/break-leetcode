package dynamic_programming;

/**
 * create by ljs on 2020/8/12 11:37
 * description:
 *
 *  714. 买卖股票的最佳时机含手续费
 *
 *  dp[n][0] = max( dp[n-1][0], dp[n-1][1] + prices[n]  )
 *  dp[n][1] = max( dp[n-1][1], dp[n-1][0] - prices[n] - fee )
 *
 *
 *  手续费一次付清： 买入 + 卖出。
 *
 *
 */
public class MaxProfit_714 {


    public int maxProfit(int[] prices, int fee) {

        if ( prices == null ) {
            return 0;
        }

        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for ( int i = 1; i < len; ++i ) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i] - fee);
        }

       return dp[len-1][0];

    }

}
