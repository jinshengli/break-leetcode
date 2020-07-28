package array;

import java.util.HashSet;
import java.util.Set;

/**
 * create by ljs on 2020/7/19 10:40
 * description:
 *
 *  编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 */
public class SetZeroes_m0108 {


    /**
     *  使用集合 保存 为0；的矩阵 行和列
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[0].length; ++j ) {
                if ( matrix[i][j] == 0 ) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // 将 集合中的每一行都赋值为 0
        for (Integer row : rows) {
            for ( int i = 0; i < matrix[0].length; ++i )
                matrix[row][i] = 0;
        }

        // 每一列赋值为0
        for (Integer col : cols) {
            for ( int i = 0; i < matrix.length; ++i  )
                matrix[i][col] = 0;
        }

    }

}
