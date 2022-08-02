package array;

import java.util.ArrayList;
import java.util.List;


/**
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 */
public class ShiftGrid_1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m *n);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            List<Integer> lst = new ArrayList<>();
            for (int j= 0; j < n; ++j) {
                lst.add(0);
            }
            ans.add(lst);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int col = (j + k) % n;
                int row = (i + (j + k) / n) % m;
                ans.get(row).set(col, grid[i][j]);
            }
        }

        return ans;
    }

}
