package depth_first_search;

import java.util.HashSet;

/**
 * create by ljs on 2020/8/15 19:02
 * description:  36. 有效的数独
 *
 *  判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 *
 *
 */
public class IsValidSudoku_36 {


    public boolean isValidSudoku(char[][] board) {
        boolean rows[][] = new boolean[10][10];
        boolean cols[][] = new boolean[10][10];
        boolean smallBlocks[][] = new boolean[10][10];

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }

                int num = board[i][j] - '0';

                int count = (i / 3) * 3 + j / 3;

                if (rows[i][num] || cols[j][num] || smallBlocks[count][num]) {
                    return false;
                }

                rows[i][num] = true;
                cols[j][num] = true;
                smallBlocks[count][num] = true;
            }
        }
        return true;
    }


    public boolean isValidSudoku01(char[][] board) {
        // 行
        HashSet<Integer>[] rows = new HashSet[10];
        // 列
        HashSet<Integer>[] cols = new HashSet[10];
        // 小方块
        HashSet<Integer>[] mx = new HashSet[10];

        for (int i = 0; i < 10; ++i) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            mx[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0';
                if (rows[i].contains(num))
                    return false;
                if (cols[j].contains(num))
                    return false;
                int index = (i / 3) * 3 + j / 3;
                if (mx[index].contains(num))
                    return false;
                rows[i].add(num);
                cols[j].add(num);
                mx[index].add(num);
            }
        }
        return true;
    }

}

