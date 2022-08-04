package offer2;


/**
 * 剑指 Offer II 013. 二维子矩阵的和
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * 实现 NumMatrix 类：
 *
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
 *
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m,n <= 200
 * -10^5<= matrix[i][j] <= 10^5
 * 0 <= row1 <= row2 < m
 * 0 <= col1 <= col2 < n
 * 最多调用 10^4 次sumRegion 方法
 */
public class oo13_NumMatrix {
    int[][] preSumMx;
    public oo13_NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        preSumMx = new int[m+1][n+1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <=n; ++j) {
                preSumMx[i][j] = matrix[i-1][j-1] + preSumMx[i-1][j] + preSumMx[i][j-1] - preSumMx[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a = preSumMx[row1][col1];
        int b = preSumMx[row1][col2 + 1];
        int c = preSumMx[row2 + 1][col1];
        int d = preSumMx[row2 + 1][col2 + 1];
        return d - b - c + a;
    }

}
