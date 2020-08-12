package dynamic_programming;

import java.util.Arrays;

/**
 * create by ljs on 2020/8/11 15:01
 * description:
 *
 *  322. 零钱兑换
 *
 *  给定不同面额的硬币 coins 和一个总金额 amount。
 *  编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 *  如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *
 *  dp[n] = min{dp[n], dp[n-coins[i]]+1}
 *
 *      i in (0...n-1)
 *
 *
 *
 *  最少的硬币个数
 *
 *

 */
public class CoinChange_322 {


    private Integer result = Integer.MAX_VALUE;

    //  暴力递归： 深度优先搜索
    public int coinChange01(int[] coins, int amount) {

        if ( coins == null || coins.length == 0 || amount < 0 ) {
            return -1;
        }
        dfs(coins, amount, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void dfs(int[] coins, int amount, int level) {

        if ( amount < 0 ) {
            return ;
        }
        if ( amount == 0 ) {
            result = Math.min(result, level);
            return;
        }
        for ( int i = 0; i < coins.length; ++i ) {
            dfs(coins, amount-coins[i], level+1);
        }
    }

    /**
     *      带记忆的搜索
     *
     *   dp[n] = dp[n-coins[i]] + 1
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        if ( coins == null || coins.length == 0 || amount < 0 ) {
            return -1;
        }

        int[] cache = new int[amount+1];
        dfsCoin(coins, amount, cache);
        return cache[amount];
    }

    private int dfsCoin(int[] coins, int amount, int[] cache) {

        if ( amount < 0 ) {
            return -1;
        }
        if ( amount == 0 ) {
            return 0;
        }
        if ( cache[amount] != 0 ) {
            return cache[amount];
        }
        int res = Integer.MAX_VALUE;
        for ( int j = 0; j < coins.length; ++j ) {
            int sub = dfsCoin(coins, amount-coins[j], cache);
            if ( sub >= 0 && sub < res) {
                res = sub + 1;
            }
        }

        cache[amount] = res == Integer.MAX_VALUE ? -1:res;
        return cache[amount];
    }

    // 动态规划。
    public int coinChange03(int[] coins, int amount) {

        if ( coins == null || coins.length == 0 || amount < 0 ) {
            return -1;
        }

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for ( int i = 1; i <= amount; ++ i ) {
            for ( int j = 0; j < coins.length; ++j ) {
                if ( i >= coins[j] ) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1: dp[amount];
    }


}
