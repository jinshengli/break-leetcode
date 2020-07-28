package recursion;

/**
 * create by ljs on 2020/7/23 21:08
 * description:
 *
 *      64. 最小路径和
 *
 *      输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 *  出一条从左上角到右下角的路径
 *
 *  TODO 暴力搜索时间超时。
 *
 *      动态规划，
 */
public class MinPathSum_64 {

    private int result;
    public int minPathSum(int[][] grid) {

        result = Integer.MAX_VALUE;
        if ( grid == null || grid.length == 0 )
            return result;
        helper(grid, 0, 0, grid[0][0]);
        return result;
    }

    private void helper(int[][] grid, int x, int y, int path) {

//        if ( x < 0 || x >= grid.length || y < 0 || y >= grid[0].length )
//            return;
        if ( x == grid.length -1 && y == grid[0].length -1 ) {
            result = Math.min(result, path);
            return;
        }

        // 每次可以有两个方向选择
        if ( x + 1 < grid.length )
            helper(grid,x+1,y, path + grid[x+1][y]); // 向下
        if ( y + 1 < grid[x].length )
            helper(grid, x, y+1, path+grid[x][y+1]); // 向右
        // 回溯

    }

}
