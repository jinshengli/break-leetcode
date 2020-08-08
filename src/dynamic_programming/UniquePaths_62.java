package dynamic_programming;

import java.util.Arrays;

/**
 * create by ljs on 2020/8/2 10:13
 * description:
 *
 *  62. 不同路径
 *
 *
 * dp[0][j] = 1  0 ~ n
 * dp[i][0] = 1  0 ~ m
 * dp[i][j] = dp[i][j-1] + dp[i-1][j]
 *
 *
 */
public class UniquePaths_62 {


    /**
     *      空间 O(m*n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        if ( m <= 0 || n <= 0 )
            return 0;

        int[][] dp = new int[m][n];
        for ( int i = 0; i < m; ++i )
            dp[i][0] = 1;

        for ( int i = 0; i < n; ++i )
            dp[0][i] = 1;

        for ( int i = 1; i < m; ++i ) {
            for ( int j = 1; j < n; ++j ) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }


    /**
     *     空间优化 O(n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths01(int m, int n) {

        if ( m <= 0 || n <= 0 )
            return 0;

        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for ( int i = 1; i < m; i++ )
            for ( int j = 1; j < n; ++j )
                dp[j] = dp[j] + dp[j-1]; // dp[j-1] 代表 dp[i][j-1]; dp[j] 代表 dp[i-1][j]

        return dp[n-1];
    }

}


