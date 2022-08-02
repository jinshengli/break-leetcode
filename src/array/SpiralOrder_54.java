package array;


import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *  m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 */
public class SpiralOrder_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean visited[][] = new boolean[m][n];
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        int total = 0;
        int row = 0, column = 0;
        int directIndex = 0;
        while (total < m*n) {
            ans.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + dx[directIndex];
            int nextColumn = column + dy[directIndex];
            if (nextRow < 0 || nextColumn < 0 || nextRow >= m || nextColumn >= n || visited[nextRow][nextColumn]) {
                directIndex = (directIndex + 1) % 4;

                // 注意重新设计方向
                nextRow = row + dx[directIndex];
                nextColumn = column + dy[directIndex];
            }
            row = nextRow;
            column = nextColumn;
            total++;
        }
        return ans;
    }

    public static void main(String[] args) {
        SpiralOrder_54 spiralOrder_54 = new SpiralOrder_54();
        int [][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers = spiralOrder_54.spiralOrder(nums);

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
