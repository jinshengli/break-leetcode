package depth_first_search;

/**
 * @author ljs
 * @since 2022/5/18 下午10:32
 **/
public class IslandPerimeter_463 {

    private int dx[] = {-1, 1, 0, 0};
    private int dy[] = {0, 0, -1, 1};
    public int islandPerimeter(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    ans = ans + dfs(grid, i, j);
                }
            }
        }
        return ans;

    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        grid[i][j] = 2;
        int ans = 0;
        for (int index = 0; index < 4; ++index) {
            ans = ans + dfs(grid, i + dx[index], j + dy[index]);
        }
        return ans;
    }
}
