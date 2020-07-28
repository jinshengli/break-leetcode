package recursion;

/**
 * create by ljs on 2020/7/24 19:53
 * description:
 *
 *  1219. 黄金矿工
 *
 *  给的数据量不是很大，可以直接暴dfs
 *
 */
public class GetMaximumGold_1219 {


    private int result;
    private int[][] dirs = { {1,0}, {-1,0}, {0,-1}, {0,1} };
    public int getMaximumGold(int[][] grid) {

        // 不许判断
        result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for ( int i = 0; i < grid.length; ++i )
            for ( int j = 0; j < grid[0].length; ++j ) {
                    if (  grid[i][j] != 0 ) { // 可以作为入口。
                        dfs(grid, i, j, 0, visited); //
                    }
            }
        return result;
    }

    private boolean isOk(int x, int y, int[][] grid, boolean[][] visited ) {
        if ( x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || visited[x][y])
            return false;
        return true;
    }

    private void dfs(int[][] grid, int x, int y, int sum, boolean[][] visited) {

        if ( !isOk(x, y, grid, visited) ) {
            result = Math.max(sum, result);
            return;
        }

        for (int[] dir : dirs) {
            visited[x][y] = true;
            dfs(grid, x+dir[0], y+dir[1], sum+grid[x][y], visited);
            visited[x][y] = false;
        }

    }


}
