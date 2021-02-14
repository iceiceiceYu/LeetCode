import java.util.Arrays;

public class Solution1319 {
    //    List<Integer>[] edges;
//    boolean[] used;
//
//    public int makeConnected(int n, int[][] connections) {
//        if (connections.length < n - 1) {
//            return -1;
//        }
//
//        edges = new List[n];
//        for (int i = 0; i < n; ++i) {
//            edges[i] = new ArrayList<>();
//        }
//        for (int[] conn : connections) {
//            edges[conn[0]].add(conn[1]);
//            edges[conn[1]].add(conn[0]);
//        }
//
//        used = new boolean[n];
//        int ans = 0;
//        for (int i = 0; i < n; ++i) {
//            if (!used[i]) {
//                dfs(i);
//                ++ans;
//            }
//        }
//
//        return ans - 1;
//    }
//
//    public void dfs(int u) {
//        used[u] = true;
//        for (int v : edges[u]) {
//            if (!used[v]) {
//                dfs(v);
//            }
//        }
//    }
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        UnionFind uf = new UnionFind(n);
        for (int[] conn : connections) {
            uf.unite(conn[0], conn[1]);
        }

        return uf.setCount - 1;
    }

    private static class UnionFind {
        int[] parent;
        int[] size;
        int n;
        int setCount;

        public UnionFind(int n) {
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
            this.size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int findSet(int x) {
            return parent[x] == x ? x : (parent[x] = findSet(parent[x]));
        }

        public boolean unite(int x, int y) {
            x = findSet(x);
            y = findSet(y);
            if (x == y) {
                return false;
            }
            if (size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            size[x] += size[y];
            --setCount;
            return true;
        }

        public boolean connected(int x, int y) {
            x = findSet(x);
            y = findSet(y);
            return x == y;
        }
    }
}
