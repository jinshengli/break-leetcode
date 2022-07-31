package graph;

import java.util.ArrayList;

public class ValidPath_1971 {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis = new boolean[n];
        ArrayList<Integer>[] path = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            path[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0];
            int b = edges[i][1];
            path[a].add(b);
            path[b].add(a);
        }
        return dfs(path, vis, source, destination);
    }

    private boolean dfs(ArrayList<Integer>[] path, boolean[] vis, int source, int destination) {
        if (source == destination) {
            return true;
        }
        vis[source] = true;
        ArrayList<Integer> nextNodeList = path[source];
        for (Integer nextNode : nextNodeList) {
            if (!vis[nextNode]) {
                if (dfs(path, vis, nextNode, destination)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 并查集解法
    public boolean validPath01(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0];
            int b = edges[i][1];
            uf.union(a, b);
        }
        return uf.isConnected(source, destination);
    }


    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int q, int p) {
            int qq = find(q);
            int pq = find(p);
            parent[qq] = pq;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }


}
