package offer;

/**
 * create by ljs on 2020/7/27 20:46
 * description:
 *
 *      每一行是左到右有序的
 *      每一列也是左到右有序的
 *
 *
 *  二维数组：
 *
 *      matrix[i][j] = matrix[i*Columns + j]
 *
 *    可以从右上角或者左下角出发；每次都可以排除一行或一列的元素。
 *
 *      0 <= n <= 1000
 *
 *      0 <= m <= 1000
 *
 *
 */
public class FindNumberIn2DArray_04 {

    /**
     *  选择右上角出发。
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if ( matrix == null || matrix.length == 0 || matrix[0].length == 0 )
            return false;

        int rows = matrix.length-1, cols = matrix[0].length-1;
        int i = 0, j = cols;
        while ( i <= rows && j >= 0 ) {
            if ( matrix[i][j] == target ) {
                return true;
            } else if ( matrix[i][j] < target ) {  // 选择的值小于目标值；可以往下移动一行查找，（需要往大的方向查找）
                i++;                                // 往下移动一行？ 它的右边的值比它大呀，你不判断吗？
                                                    // 答： 它右边的值也是比目标大的；因为我刚才是从右边比较过来的，
            } else {  // 比目标值大；排除比当前值更加大的。
                j--;
            }

        }
        return false;
    }

    // 从左下角开始比较，
    public boolean findNumberIn2DArray01(int[][] matrix, int target) {

        if ( matrix == null || matrix.length == 0 || matrix[0].length == 0 )
            return false;

        int rows = matrix.length-1, cols = matrix[0].length-1;
        int i = rows, j = 0;
        while ( i >= 0 && j <= cols ) {
            if ( matrix[i][j] == target )
                return true;
            if ( matrix[i][j] < target ) {
                j++; // 排除更加小的。列
            } else {
                i--; // 排除更加大的 行
            }
        }
        return false;
    }


}
