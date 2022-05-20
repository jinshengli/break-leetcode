package depth_first_search;

/**
 *
 * 1905. 统计子岛屿
 *
 * @author ljs
 * @since 2022/5/19 下午11:14
 **/
public class CountSubIslands_1905 {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for (int i = 0; i < grid2.length; ++i) {
            for (int j = 0; j < grid2[0].length; ++j) {
                if (grid2[i][j] == 1 && grid1[i][j] == 0) {
                    dfs(grid2, i, j);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < grid2.length; ++i) {
            for (int j = 0; j < grid2[0].length; ++j) {
                if (grid2[i][j] == 1) {
                    dfs(grid2, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        for (int index = 0; index < 4; ++index) {
            dfs(grid, i + dx[index], j + dy[index]);
        }
    }
}
