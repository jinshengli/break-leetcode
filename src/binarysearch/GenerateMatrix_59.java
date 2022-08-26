package binarysearch;


/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 */

public class GenerateMatrix_59 {

    // 旋转遍历。
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int start = 1;
        int[][] dir = new int[][]{{0, 1}, {1,0}, {0, -1}, {-1, 0}}; // 右下左上
        int dirIndex = 0;
        int row = 0;
        int col = 0;
        while (start <= n *n) {
            ans[row][col] = start;
            start++;
            int nextRow = row + dir[dirIndex][0];
            int nextCol = col + dir[dirIndex][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || ans[nextRow][nextCol] != 0) {
                dirIndex = (dirIndex + 1) % 4;
            }
            row = row + dir[dirIndex][0];
            col = col + dir[dirIndex][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
    }

    public int[][] generateMatrix01(int n) {
        int[][] ans = new int[n][n];
        int start = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        while (start <= n * n) {
            for (int i = left; i <= right; ++i) {
                ans[top][i] = start++;
            }
            top++;
            for (int i = top; i <= bottom; ++i) {
                ans[i][right] = start++;
            }
            right--;
            for (int i = right; i >= left; --i) {
                ans[bottom][i] = start++;
            }
            bottom--;
            for (int i = bottom; i >= top; --i) {
                ans[i][left] = start++;
            }
            left++;
        }
        return ans;
    }
}
