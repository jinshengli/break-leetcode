package weeken.w303;


/**
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 *
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 *
 *
 *
 */
public class EqualPairs_6125 {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (compareRowAndCol(grid, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean compareRowAndCol(int[][] grid, int i, int j) {
        int[] row = grid[i];
        int[] col = new int[grid.length];
        for (int k = 0; k < col.length; ++k) {
            col[k] = grid[k][j];
        }
        for (int k = 0; k < row.length; ++k) {
            if (row[k] != col[k]) {
                return false;
            }
        }
        return true;
    }
}
