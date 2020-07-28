package array;

/**
 * create by ljs on 2020/7/19 10:55
 * description:
 *
 *  给定一个含有 M x N 个元素的矩阵（M 行，N 列）
 *  ，请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示
 *
 */
public class FindDiagonalOrder_498 {


    /**
     *
     * // TODO 思路出错， 不是遍历n遍， 而是N+M-1遍
     *
     *      对角线   n 次遍历
     *          每一次中 判断 n 是 奇数或偶数
     *
     *          偶数： 正函数 row = n, row--, col++  到 row=0
     *          奇数： 负函数 col = n, col--, row++  到 col=0
     *
     *
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {

        if ( matrix == null )
            return null;
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int result[] = new int[row*col+1];
        int index = 0;
        for ( int i = 0; i <= row; ++i ) {
            if ( i % 2 == 0 ) {
                int r = i, c = 0;
                while ( r >= 0 )
                    result[index++] = matrix[r--][c++];
            } else {
                int r = 0, c = i;
                while ( c >= 0 )
                    result[index++] = matrix[r++][c--];
            }
        }

        return result;
    }


}
