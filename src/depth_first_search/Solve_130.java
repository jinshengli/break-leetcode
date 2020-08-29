package depth_first_search;

/**
 * create by ljs on 2020/7/30 20:42
 * description:
 *
 *  130. 被围绕的区域
 *
 *  给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 *
 *  先将 O --> #      经典dfs.,
 *
 */
public class Solve_130 {

    public void solve(char[][] board) {

        if ( board == null || board.length == 0 )
            return;

        for ( int i = 0; i < board.length; ++i ) {
            for ( int j = 0; j < board[0].length; ++j ) {
                boolean isEdge = i == 0 || j == 0 || i == board.length -1 || j == board[0].length -1;
                if ( isEdge && board[i][j] == 'O' ) {
                    dfs(board, i, j);
                }
            }
        }

        for ( int i = 0; i < board.length; ++i ) {
            for ( int j = 0; j < board[0].length; ++j ) {
                if ( board[i][j] == '#')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }

    }

    private void dfs(char[][] board, int x, int y) {

        if ( x < 0 || y < 0 || x >= board.length || y >= board[0].length
                || board[x][y] == 'X' || board[x][y] == '#')
            return;
        board[x][y] = '#';
        dfs(board, x +1, y);
        dfs(board,x-1, y);
        dfs(board, x, y-1);
        dfs(board, x, y+1);

    }


}
