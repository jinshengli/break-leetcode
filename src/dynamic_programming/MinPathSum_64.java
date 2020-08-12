package dynamic_programming;

/**
 * create by ljs on 2020/8/11 18:45
 * description:   64. 最小路径和
 *
 *  给定一个包含非负整数的 m x n 网格，
 *  请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 */
public class MinPathSum_64 {

    /**
     *      dp[i][j] = min{dp[i-1][j],dp[i][j-1]} + grid[i][j];
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        if ( grid == null || grid.length == 0 ) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];
        for ( int i = 1; i < cols; ++i ) { // 初始化dp的第一行。
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for ( int j = 1; j < rows; ++j ) { // 初始化dp的第一列
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }

        for ( int i = 1; i < rows; ++i ) {
            for ( int j = 1; j < cols; ++j ) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[rows-1][cols-1];
    }

    /**
     *  动态规划对内存进行优化，
     * @param grid
     * @return
     */
    public int minPathSum01(int[][] grid) {

        if ( grid == null || grid.length == 0 ) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;


        for ( int i = 1; i < cols; ++i ) { // 初始化dp的第一行。
            grid[0][i] = grid[0][i-1] + grid[0][i];
        }

        for ( int j = 1; j < rows; ++j ) { // 初始化dp的第一列
            grid[j][0] = grid[j-1][0] + grid[j][0];
        }

        for ( int i = 1; i < rows; ++i ) {
            for ( int j = 1; j < cols; ++j ) {
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }

        return grid[rows-1][cols-1];
    }
}
