package dynamic_programming;

/**
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 *
 */
public class MaxProduct_152 {

    public static int maxProduct(int[] nums) {
        int length = nums.length;
        int dp[][] = new int[length][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        int res = nums[0];
        for (int i = 1; i < length; ++i) {
            dp[i][0] = Math.max(dp[i-1][0]*nums[i], dp[i-1][1]*nums[i]);
            dp[i][0] = Math.max(dp[i][0], nums[i]);

            dp[i][1] = Math.min(dp[i-1][0]*nums[i], dp[i-1][1]*nums[i]);
            dp[i][1] = Math.min(dp[i][1], nums[i]);
//            System.out.println("(" + i + ", " + 0 + ") = " + dp[i][0]);
//            System.out.println("(" + i + ", " + 1 + ") = " + dp[i][1]);
            res = Math.max(res, dp[i][0]);
        }

        return res;
    }

    public static void main(String[] args) {
        int num[] = {-2};
        System.out.println(maxProduct(num));
    }
}
