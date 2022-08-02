package offer;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *
 */
public class MaxProfit_63 {

    public int maxProfit(int[] prices) {
        // dp[i] 第i天卖出获取最大收益.  minPrice是前i-1天中，股票的最低价格。
        // dp[i] = prices[i] - minPrice;
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int len = prices.length;
        int dp[] = new int[len];
        int minPrice = prices[0];
        dp[0] = 0;
        for (int i = 1; i < len; ++i) {
            dp[i] = prices[i] - minPrice;
            minPrice = Math.min(prices[i], minPrice);
        }

        int maxProfit = 0;
        for (int i = 0; i < dp.length; ++i) {
            if (maxProfit < dp[i]) {
                maxProfit = dp[i];
            }
        }

        return maxProfit;
    }

}
