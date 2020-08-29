package depth_first_search;

import java.util.HashSet;

/**
 * create by ljs on 2020/8/15 19:20
 * description:
 *
 *  编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
 *
 *
 *  我可以先遍历一遍整个 9 * 9
 *
 *  rows
 *  cols
 *  box
 *
 *
 *
 *
 *
 */
public class SolveSudoku_37 {

    private boolean[][] rows = new boolean[9][10];
    private boolean[][] cols = new boolean[9][10];
    private boolean[][] boxs = new boolean[9][10];

    private boolean reslved = false;

    public void solveSudoku(char[][] board) {

        for ( int i = 0; i < board.length; ++i ) {
            for ( int j = 0; j < board[0].length; ++j ) {
                if ( board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0';
                setFlag(i,j, num);
            }
        }

        dfs(board,0,0);
    }

    private boolean notOk(char[][] board, int i, int j, int num) {

        int index = (i/3)*3 + j/3;

        return rows[i][num] || cols[j][num] || boxs[index][num];
    }

    private void dfs(char[][] board, int row, int col) {

        if ( board[row][col] == '.' ) {
            for ( int num = 1; num <= 9; ++num   ) {
                if ( notOk(board, row, col, num) )
                    continue;
                // 选择了 一个字符
                char c = (char) (num + '0');
                board[row][col] = c;
                setFlag(row,col,num);
                if ( (row == board.length-1) && (col == board[0].length-1) ) {
                    reslved = true;
                    return;
                }
                if ( col == board[0].length-1 )
                    dfs(board,row+1, 0);
                else {
                    dfs(board,row, col+1);
                }
                if ( !reslved ) {
                    removeFlag(row,col,num);
                    board[row][col] = '.';
                }
            }

        } else {

            if ( (row == board.length-1) && (col == board[0].length-1) ) {
                reslved = true;
                return;
            }
            if ( col == board[0].length-1 )
                dfs(board,row+1, 0);
            else {
                dfs(board,row, col+1);
            }
        }

    }

    private void removeFlag(int row, int col, int num) {
        int index = (row/3)*3 + col/3;
        rows[row][num] = false;
        cols[col][num] = false;
        boxs[index][num] = false;
    }

    private void setFlag(int i, int j, int num) {
        int index = (i/3)*3 + j/3;
        rows[i][num] = true;
        cols[j][num] = true;
        boxs[index][num] = true;
    }


}
