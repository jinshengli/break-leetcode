package array;

/**
 * create by ljs on 2020/7/19 10:10
 * description:
 */
public class Rotate_m0107 {

    /**
     * o(n^2) 内存和时间复杂度
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int [][]matrix_new = new int[n][n];

        for ( int i = 0; i < n; ++i ) {
            for ( int j = 0; j < n; ++j ) {
                // 旋转后，第i行第j个元素 应该到 倒数第i列，第j个元素。
                matrix_new[j][n-i-1] = matrix[i][j];
            }
        }

        for ( int i = 0; i < n; ++i ) {
            for ( int j = 0; j < n; ++j ) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }


    public void rotate01(int[][] matrix) {
        int n = matrix.length;

    }


    //TODO 需要推到公式，循环替换





}
