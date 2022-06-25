package offer;

import java.util.Arrays;

/**
 * 剑指 Offer II 091. 粉刷房子
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 *
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 *
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 *
 * 请计算出粉刷完所有房子最少的花费成本。
 *
 * costs.length == n
 * costs[i].length == 3
 * 1 <= n <= 100
 * 1 <= costs[i][j] <= 20
 */

public class MinCost_091 {


    // 1维优化代码. 官方题解。
    public int minCost03(int[][] costs) {
        int N = costs.length;
        int dp[] = new int[3];

        for (int i = 0; i < 3; ++i) {
            dp[i] = costs[0][i];
        }

        for (int i = 1; i < N; ++i) {
            int dpNew[] = new int[3];
            for (int j = 0; j < 3; ++j) {
               dpNew[j] = Math.min(dp[(j + 1) % 3], dp[(j + 2) % 3]) + costs[i][j];  // 重点。
            }
            dp = dpNew;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; ++i) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }



    // 优化一维数组 效果差
    public int minCost02(int[][] costs) {
        int N = costs.length;
        int dp[] = new int[3];

        for (int i = 0; i < 3; ++i) {
            dp[i] = costs[0][i];
        }

        int min0, min1, min2;
        for (int i = 1; i < N; ++i) {
            min0 = Math.min(dp[1], dp[2]) + costs[i][0];
            min1 = Math.min(dp[0], dp[2]) + costs[i][1];
            min2 = Math.min(dp[0], dp[1]) + costs[i][2];
            dp[0] = min0;
            dp[1] = min1;
            dp[2] = min2;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; ++i) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;

    }


    // 滚动数组, 内存优化
    public int minCost01(int[][] costs) {
        int N = costs.length;
        int dp[][] = new int[2][3];

        for (int i = 0; i < 3; ++i) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < N; ++i) {
            int cur = i & 1;
            int pre = (i-1) & 1;
            dp[cur][0] = Math.min(dp[pre][1], dp[pre][2]) + costs[i][0];
            dp[cur][1] = Math.min(dp[pre][0], dp[pre][2]) + costs[i][1];
            dp[cur][2] = Math.min(dp[pre][0], dp[pre][1]) + costs[i][2];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; ++i) {
            ans = Math.min(ans, dp[(N-1) & 1][i]);
        }
        return ans;
    }


    /**
     * f[n][3]
     *
     *
     * j ===> {0, 1, 2}
     *
     *
     * f[i][0] = min{f[i-1][1], f[i-1][2]} + costs[i][0]
     * f[i][1] = min{f[i-1][0], f[i-1][2]} + costs[i][1]
     * f[i][2] = min{f[i-1][0], f[i-1][1]} + costs[i][2]
     *
     *
     *
     * min{f[i] ... {0,1,2}
     */
    public int minCost(int[][] costs) {
        int N = costs.length;
        int dp[][] = new int[N][3];

        for (int i = 0; i < 3; ++i) {
           dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < N; ++i) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; ++i) {
            ans = Math.min(ans, dp[N-1][i]);
        }
        return ans;
    }
}
