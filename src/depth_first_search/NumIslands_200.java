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


    public int numIslands(char[][] grid) {

        if ( grid == null || grid.length == 0 ) {
            return 0;
        }
        int count  = 0;
        for ( int i = 0; i < grid.length; ++i ) {
            for ( int j = 0; j < grid[0].length; ++j ) {
                if ( grid[i][j] == '1' ) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {

        if ( i < 0 || j < 0 || i >= grid.length ||
                j >= grid[0].length || grid[i][j] == '0' )
            return;

        grid[i][j] = '0';
        dfs(grid, i +1 ,j);
        dfs(grid, i-1, j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);

    }
}
