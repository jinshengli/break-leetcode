package recursion;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *
 */

public class Exist_79 {

    int []dx = {-1, 1, 0, 0};
    int []dy = {0, 0, -1, 1};
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        boolean visited[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == chars[0]) {
                    if (backTrace(board, i, j, 0, chars, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backTrace(char[][] board, int i, int j, int start, char[] chars, boolean[][] visited) {

        if (board[i][j] != chars[start]) {
            return false;
        }

        // 边界
        if (start == chars.length-1 && board[i][j] == chars[start] ) {
            return true;
        }

        visited[i][j] = true;
        for (int d = 0; d < 4; ++d) {
            int x = i + dx[d];
            int y = j + dy[d];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if (!visited[x][y]) {
                    if (backTrace(board, x, y, start + 1, chars, visited)) {
                        return true;
                    }
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        Exist_79 exist_79 = new Exist_79();
        char[][] nums = new char[3][4];
        for (int i = 0; i < 3; ++i) {

        }

        nums[0] = new char[]{'A', 'B', 'C', 'E'};
        nums[1] = new char[]{'S', 'F', 'C', 'S'};
        nums[2] = new char[]{'A', 'D', 'E', 'E'};
//        [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
//        "ABCCED"
        boolean abcced = exist_79.exist(nums, "ABCCED");
        System.out.println(abcced);
    }
}
