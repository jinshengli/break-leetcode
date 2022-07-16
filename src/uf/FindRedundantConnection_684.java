package uf;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

/**
 * 684. 冗余连接
 * 树可以看成是一个连通且 无环 的 无向 图。
 *
 * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。
 * 图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 *
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。
 *
 *
 */

public class FindRedundantConnection_684 {


    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n+1);
        for (int i = 0; i < n; ++i) {
            if (uf.isConnection(edges[i][0], edges[i][1])) {
                return edges[i];
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return new int[]{-1, -1};
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
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int p, int q) {
            parent[find(p)] = find(q);
        }

        public boolean isConnection(int x, int y) {
            return find(x) == find(y);
        }
    }


}
