package binarysearch;


/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 */
public class SearchMatrix_74 {

    // 找到第一行中，最后一次小于等于target的行， 在行上二分查找
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m - 1;

        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        int rowIndex = low;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[rowIndex][mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return matrix[rowIndex][left] == target;
    }

    // 二维看成维数组
    public static boolean searchMatrix02(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid/n][mid%n] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return matrix[left/n][left%n] == target;
    }

    public static void main(String[] args) {
        int [][]nums = {{1}};
        boolean b = searchMatrix(nums, 3);

        System.out.println(b);
    }


    // 这个不叫二分法。 变量 + 二分。
    public boolean searchMatrix01(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; ++i) {
            if (hasTarget(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasTarget(int[] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return matrix[left] == target;
    }
}
