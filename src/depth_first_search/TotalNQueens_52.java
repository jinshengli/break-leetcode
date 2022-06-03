package depth_first_search;

import java.util.HashSet;

/**
 * n 皇后的不同解法
 *
 */
public class TotalNQueens_52 {

    private int totalCount = 0;

    public int totalNQueens(int n) {
        helper(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return totalCount;
    }

    private void helper(int row, int n, HashSet<Integer> cols, HashSet<Integer> pie, HashSet<Integer> na) {
        if (row == n) {
            totalCount++;
            return;
        }

        for (int col = 0; col < n; ++col) {
            if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }
            cols.add(col);
            pie.add(row + col);
            na.add(row - col);
            helper(row + 1, n, cols, pie, na);
            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
        }
    }

    public static void main(String[] args) {
        TotalNQueens_52 totalNQueens_52 = new TotalNQueens_52();
        int i = totalNQueens_52.totalNQueens(4);
        System.out.println(i);
    }
}
