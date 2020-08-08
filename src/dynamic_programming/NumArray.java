package dynamic_programming;

/**
 * create by ljs on 2020/8/7 15:15
 * description:
 *
 *  303. 区域和检索 - 数组不可变
 *
 *  给定一个整数数组  nums，
 *  求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 *   nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 *  dp[i][j] = nums[i] ; if i == j
 *  dp[i][j] = dp[i][j-1] + nums[j] if i != j

 *
 *
 *  sum[i] 从第0位数到 i 位置的数组之和。
 *
 *  sumRange(i,j) = sum[j+1] - sum[i]
 *
 */
public class NumArray {

//    private int[][] dp;
//
//    // 超时了
//    public NumArray(int[] nums) {
//        int length = nums.length;
//        dp = new int[length][length];
//
//        for ( int i = 0;  i < length; ++i ) {
//            for ( int j = i; j < length; ++j ) {
//                if ( i == j )
//                    dp[i][j] = nums[i];
//                else
//                    dp[i][j] = dp[i][j-1] + nums[j];
//            }
//        }
//
//    }
//
//    public int sumRange(int i, int j) {
//        return this.dp[i][j];
//    }

    private int[] sum;

    public NumArray(int[] nums) {

        int len = nums.length;
        sum = new int[len];
        sum[0] = nums[0];
        for ( int i = 1; i < len; ++i )
            sum[i] = sum[i-1] + nums[i];
    }

    public int sumRange(int i, int j) {

        if ( i == 0 ) {
            return sum[j];
        } else {
            return sum[j] - sum[i-1];
        }

    }

}
