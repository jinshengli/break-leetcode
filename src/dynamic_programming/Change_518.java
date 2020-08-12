package dynamic_programming;

/**
 * create by ljs on 2020/8/11 16:11
 *
 * description:     518. 零钱兑换 II
 *
 *  给定不同面额的硬币和一个总金额。
 *  写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 *          1         2        3
 *       1  2 3    1  2 3   1 2 3
 *
 *
 */
public class Change_518 {

    private Integer result;
    public int change(int amount, int[] coins) {
        result = 0;
        dfs(amount, coins, 0);
        return result;
    }

    // 超时
    private void dfs(int amount, int[] coins, int k) {  // k 参数 完成剪枝。

        if ( amount < 0 )
            return;

        if ( amount == 0 ) {
            result ++;
            return;
        }

        for ( int i = k; i < coins.length; ++i ) {
            dfs(amount-coins[i], coins, i);
        }

    }

    /**
     *    dp[n] =  dp[n] + dp[n-coins[i]]  i in (0...n-1)
     * @param amount
     * @param coins
     * @return   错误的答案
     */
    public int change01(int amount, int[] coins) {

        if ( coins == null || coins.length == 0 ) {
            return 0;
        }

        int[] dp = new int[amount+1];
        dp[0] = 1; // 为啥？
        for ( int i = 1; i <= amount; ++i ) {
            for ( int j = 0; j < coins.length; ++j ) {
                if ( i < coins[j] )
                    continue;
                dp[i] = dp[i] + dp[i-coins[j]] ;
            }
        }

        return dp[amount];

    }

    public int change02(int amount, int[] coins) {

        if ( coins == null || coins.length == 0 ) {
            return 0;
        }

        int[] dp = new int[amount+1];
        dp[0] = 1; // base
        for ( int i = 0; i < coins.length; ++i )
            for ( int j = coins[i]; j <= dp.length; ++j ) {
                if ( j > coins[i] ) {
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }

        return dp[amount];

    }

}
