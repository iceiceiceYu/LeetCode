import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1584 {
    public static void main(String[] args) {
        System.out.println(minCostConnectPoints(new int[][]{
                new int[]{0, 0},
                new int[]{2, 2},
                new int[]{3, 10},
                new int[]{5, 2},
                new int[]{7, 0}
        }));
        System.out.println(minCostConnectPoints(new int[][]{
                new int[]{3, 12},
                new int[]{-2, 5},
                new int[]{-4, 1}
        }));
        System.out.println(minCostConnectPoints(new int[][]{
                new int[]{0, 0},
                new int[]{1, 1},
                new int[]{1, 0},
                new int[]{-1, 1}
        }));
        System.out.println(minCostConnectPoints(new int[][]{
                new int[]{-1000000, -1000000},
                new int[]{1000000, 1000000}
        }));
        System.out.println(minCostConnectPoints(new int[][]{
                new int[]{0, 0}
        }));
    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DisjointSetUnion dsu = new DisjointSetUnion(n);
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(dist(points, i, j), i, j));
            }
        }
        edges.sort(Comparator.comparingInt(edge -> edge.len));
        int ret = 0, num = 1;
        for (Edge edge : edges) {
            int len = edge.len, x = edge.x, y = edge.y;
            if (dsu.unionSet(x, y)) {
                ret += len;
                num++;
                if (num == n) {
                    break;
                }
            }
        }
        return ret;
    }

    private static int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }

    private static class DisjointSetUnion {
        int[] f;
        int[] rank;
        int n;

        public DisjointSetUnion(int n) {
            this.n = n;
            this.rank = new int[n];
            Arrays.fill(this.rank, 1);
            this.f = new int[n];
            for (int i = 0; i < n; i++) {
                this.f[i] = i;
            }
        }

        public int find(int x) {
            return f[x] == x ? x : (f[x] = find(f[x]));
        }

        public boolean unionSet(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                return false;
            }
            if (rank[fx] < rank[fy]) {
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            rank[fx] += rank[fy];
            f[fy] = fx;
            return true;
        }
    }

    private static class Edge {
        int len, x, y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }
}
