package depth_first_search;


/**
 * 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class FindCircleNum547 {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                dfs(isConnected, vis, i);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int[][] isConnected, boolean[] vis, int startNode) {
        vis[startNode] = true;
        for (int i = 0; i < vis.length; ++i) {
            if (isConnected[startNode][i] == 1 && !vis[i])  {
                dfs(isConnected, vis, i);
            }
        }
    }
}
