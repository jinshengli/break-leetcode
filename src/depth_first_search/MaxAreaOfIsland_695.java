package depth_first_search;

/**
 *
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/max-area-of-island
 * @author ljs
 * @since 2022/5/18 下午11:22
 **/
public class MaxAreaOfIsland_695 {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if (grid == null || grid.length == 0) {
            return maxArea;
        }

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j);
                    if (count > maxArea) {
                        maxArea = count;
                    }
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j>= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        int count = 1;
        for (int index = 0; index < 4; ++index) {
            count += dfs(grid, i + dx[index], j + dy[index]);
        }
        return count;
    }

}
