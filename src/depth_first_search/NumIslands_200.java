package depth_first_search;

/**
 * create by ljs on 2020/7/30 21:11
 * description:
 *
 *  200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 * dfs 一路走尽头， 标记每次走过的路径， 没路走回退上一层再做选择。
 *
 */
public class NumIslands_200 {

    int[][] dir = new int[][]{{1,0}, {-1, 0}, {0,1}, {0, -1}};

    public int numIslands(char[][] grid) {
        if ( grid == null || grid.length == 0 ) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (vis[i][j] == false && grid[i][j] == '1') {
                    dfs(grid, vis, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, boolean[][] vis, int x, int y) {
        vis[x][y] = true;
        for (int k = 0; k < 4; ++k) {
            int newX = x + dir[k][0];
            int newY = y + dir[k][1];
            if (inAear(grid, newX, newY) && grid[newX][newY] == '1' &&  vis[newX][newY] == false) {
                dfs(grid, vis, newX, newY);
            }
        }
    }

    private boolean inAear(char[][] grid, int newX, int newY) {
        return newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length;
    }


    public int numIslands01(char[][] grid) {

        if ( grid == null || grid.length == 0 ) {
            return 0;
        }
        int count  = 0;
        for ( int i = 0; i < grid.length; ++i ) {
            for ( int j = 0; j < grid[0].length; ++j ) {
                if ( grid[i][j] == '1' ) {
                    dfs01(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs01(char[][] grid, int i, int j) {

        if ( i < 0 || j < 0 || i >= grid.length ||
                j >= grid[0].length || grid[i][j] == '0' )
            return;

        grid[i][j] = '0';
        dfs01(grid, i +1 ,j);
        dfs01(grid, i-1, j);
        dfs01(grid,i,j+1);
        dfs01(grid,i,j-1);

    }
}
