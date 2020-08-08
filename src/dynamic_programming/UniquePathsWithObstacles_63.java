package dynamic_programming;

/**
 * create by ljs on 2020/8/2 10:37
 * description:
 *
 *      63. 不同路径 II
 *
 *      现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *      obstacleGrid[i][j] == 1; 代表是障碍物
 *
 *       dp[i][j] = obstacleGrid[i][j] == 1 ? 0: dp[i][j-1] + dp[i-1][j];
 */
public class UniquePathsWithObstacles_63 {

    /**
     *  空间未优化： O(m*n)
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if ( obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0 )
            return 0;

        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        int f = 1;
        for ( int i = 0; i < rows; ++i ) {
            if ( obstacleGrid[i][0] == 1 ) {
                f = 0;
            }
            dp[i][0] = f;
        }

        f = 1;
        for ( int j = 0; j < cols; ++j ) {
            if ( obstacleGrid[0][j] == 1 ) {
                f =  0;
            }
            dp[0][j] = f;
        }

        for ( int i = 1; i < rows; ++i ) {
            for ( int j = 1; j < cols; ++j ) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0: dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[rows-1][cols-1];

    }

    /**
     *      优化dp 第一行 和 第一列初始化的 代码
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles01(int[][] obstacleGrid) {

        if ( obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0 )
            return 0;

        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];

        for ( int i = 0; i < rows && obstacleGrid[i][0] == 0; ++i )
            dp[i][0] = 1;

        for ( int j = 0; j < cols && obstacleGrid[0][j] == 0; ++j )
            dp[0][j] = 1;

        for ( int i = 1; i < rows; ++i ) {
            for ( int j = 1; j < cols; ++j ) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0: dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[rows-1][cols-1];

    }

    /**
     *  使用滚动数组； 进行空间优化。
     *
     *  dp[j] 代表走到 第 j 个位置时的 路数，
     *
     *  每一次循环， 代表走到下一行去； 迭代求出结果，
     *
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles02(int[][] obstacleGrid) {

        if ( obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0 )
            return 0;

        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;

        int[] dp = new int[cols];

        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for ( int i = 0; i < rows; ++i ) {
            for ( int j = 0; j < cols; ++j ) {

                if ( obstacleGrid[i][j] == 1 ) {
                    dp[j] = 0;
                    continue;
                }
                if ( j-1 >= 0 )
                    dp[j] = dp[j] + dp[j-1];

            }
        }

        return dp[cols-1];
    }

}
