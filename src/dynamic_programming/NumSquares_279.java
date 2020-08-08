package dynamic_programming;

/**
 * create by ljs on 2020/8/8 8:48
 * description:
 *
 *  279. 完全平方数
 *
 *  给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 *  你需要让组成和的完全平方数的个数最少。
 *
 *
 *
 *  和爬楼梯问题类似
 *
 */
public class NumSquares_279 {


    /**
     *      sqrtArray: 1... i 的平方数； i*i <= n
     *
     *      dp[n] = dp[n-sqrtArray[i]] + 1;
     *
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {

        if ( n <= 1 ) {
            return n;
        }

        int sqrt = (int) Math.sqrt(n) + 1;
        int[] sqrtArray = new int[sqrt];
        int[] dp = new int[n+1];

        for ( int i = 0; i < sqrt; ++i ) {
            sqrtArray[i] = i * i;
        }

        for ( int i = 0; i < dp.length; ++i ) {
            dp[i] = i;
        }

        for ( int i = 2; i <= n; ++i ) {
            for ( int j = 0; j < sqrtArray.length; ++j ) {
                if ( i >= sqrtArray[j] )
                    dp[i] = Math.min(dp[i], dp[i-sqrtArray[j]] + 1);
            }
        }

        return dp[n];
    }


}
