package uf;


/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 */
public class solve_130 {

    public static void main(String[] args) {
        solve_130 solve_130 = new solve_130();
        solve_130.solve(new char[][]{{'X','O','X'},{'O','X','O'},{'X','O','X'}});
    }

    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;
        int dummy = m * n;
        UnionFind uf = new UnionFind(m * n + 1);

        // 第一列和最后一列 合并是 O的节点到一个集合中
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O') {
                // i * n + 0
                uf.union(getIndex(i, 0, n), dummy);
            }
            if (board[i][n-1] == 'O') {
                uf.union(getIndex(i, n - 1, n), dummy);
            }
        }

        // 1 row, m-1 row
        for (int i = 0; i < n; ++i) {
            if (board[0][i] == 'O') {
                uf.union(getIndex(0, i, n), dummy);
            }
            if (board[m-1][i] == 'O') {
                uf.union(getIndex(m-1, i, n), dummy);
            }
        }

        //
        int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0, -1}};

        for (int i = 0; i < m - 1; ++i) {
            for (int j = 0; j < n-1; ++j) {
                if (board[i][j] == 'O') {
                    if (board[i][j+1] == 'O') {
                        uf.union(getIndex(i, j, n), getIndex(i, j+1, n));
                    }
                    if (board[i+1][j] == 'O') {
                        uf.union(getIndex(i, j, n), getIndex(i + 1, j, n));
                    }
                }
            }
        }

        int parent = uf.find(dummy);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (parent == uf.find(getIndex(i, j, n))) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public int getIndex(int x, int y, int col) {
        return x * col + y;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; ++i) {
                this.parent[i] = i;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int p, int q) {
            int pp = find(p);
            int pq = find(q);
            if (pp == pq) return;
            parent[pp] = pq;
        }
    }
}

//[["X","O","X"],
// ["O","X","O"],
// ["X","O","X"]]

//[["X","O","X"],
// ["O","X","O"],
// ["X","O","X"]]
