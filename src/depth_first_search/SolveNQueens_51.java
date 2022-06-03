package depth_first_search;

import java.util.*;


/**
 * N 皇后
 *
 *
 */
public class SolveNQueens_51 {




    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> xieSet = new HashSet<>();
        Set<Integer> fanSet =  new HashSet<>();
        solve(n,0, colSet, xieSet, fanSet, ans, new ArrayList<>());
        return ans;
    }

    private void solve(int n, int row, Set<Integer> colSet, Set<Integer> xieSet, Set<Integer> fanSet, List<List<String>> ans, ArrayList<String> list) {
        if (n == row) {
            if (n == row) {
                ans.add(new ArrayList<>(list));
            }
        }

        for (int i = 0; i < n; ++i) {
            if (colSet.contains(i) || xieSet.contains(row + i) || fanSet.contains(row-i)) {
                continue;
            }
            colSet.add(i);
            xieSet.add(i + row);
            fanSet.add(row - i);
            char[] r = new char[n];
            Arrays.fill(r, '.');
            r[i] = 'Q';
            list.add(new String(r));
            solve(n, row + 1, colSet, xieSet, fanSet, ans, list);
            colSet.remove(i);
            xieSet.remove(i +row);
            fanSet.remove(row - i);
            list.remove(list.size() - 1);
        }
    }


    /**
     *  dfs 测试位置还能不能放
     */
    public List<List<String>> solveNQueens01(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i ) {
            Arrays.fill(board[i], '.');
        }
        dfs(n, board,0, ans);
        return ans;
    }

    private void dfs(int n, char[][] board, int row, List<List<String>> ans) {
        if (n == row) {
            List<String> tmp =  new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; ++j) {
                    sb.append(board[i][j]);
                }
                tmp.add(sb.toString());
            }
            ans.add(tmp);
        }

        for (int col = 0; col < n; ++col) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                dfs(n, board, row + 1, ans);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 斜线 45度
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 反斜线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SolveNQueens_51 solveNQueens_51 = new SolveNQueens_51();
        List<List<String>> lists = solveNQueens_51.solveNQueens(4);

        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("----------------");
        }
    }
}
