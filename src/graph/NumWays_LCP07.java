package graph;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 *
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 *
 * 2 <= n <= 10
 *  1 <= k <= 5
 * 1 <= relation.length <= 90, 且 relation[i].length == 2
 * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 *
 *
 */
public class NumWays_LCP07 {

    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k+1][n];
        dp[0][0] = 1;
        for (int i = 1; i <=k; ++i) {
            for (int[] ints : relation) {
                int a = ints[0];
                int b = ints[1];
                dp[i][b] += dp[i-1][a];
            }
        }
        return dp[k][n-1];
    }

    public int numWays01(int n, int[][] relation, int k) {
        List<Integer>[] path = new List[n];
        for (int i = 0; i < n; ++i) {
            path[i] = new ArrayList<>();
        }
        for (int i = 0; i < relation.length; ++i) {
            int a = relation[i][0];
            int b = relation[i][1];
            path[a].add(b);
        }
        return dfs(0, n - 1, 0, k, path);
    }

    private int dfs(int start, int end, int level, int k, List<Integer>[] path) {
        if (level == k) {
            return start == end ? 1:0;
        }
        int ans = 0;
        for (Integer nextNode : path[start]) {
            ans += dfs(nextNode, end, level + 1, k, path);
        }
        return ans;
    }

}
