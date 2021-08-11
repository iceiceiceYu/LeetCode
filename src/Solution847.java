import java.util.LinkedList;
import java.util.Queue;

public class Solution847 {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; ++i) {
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int u = tuple[0], mask = tuple[1], dist = tuple[2];
            if (mask == (1 << n) - 1) {
                ans = dist;
                break;
            }
            // 搜索相邻的节点
            for (int v : graph[u]) {
                // 将 mask 的第 v 位置为 1
                int maskV = mask | (1 << v);
                if (!seen[v][maskV]) {
                    queue.offer(new int[]{v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return ans;
    }

//    public int shortestPathLength(int[][] graph) {
//        int n = graph.length;
//        int[][] d = new int[n][n];
//        for (int i = 0; i < n; ++i) {
//            Arrays.fill(d[i], n + 1);
//        }
//        for (int i = 0; i < n; ++i) {
//            for (int j : graph[i]) {
//                d[i][j] = 1;
//            }
//        }
//        // 使用 floyd 算法预处理出所有点对之间的最短路径长度
//        for (int k = 0; k < n; ++k) {
//            for (int i = 0; i < n; ++i) {
//                for (int j = 0; j < n; ++j) {
//                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
//                }
//            }
//        }
//
//        int[][] f = new int[n][1 << n];
//        for (int i = 0; i < n; ++i) {
//            Arrays.fill(f[i], Integer.MAX_VALUE / 2);
//        }
//        for (int mask = 1; mask < (1 << n); ++mask) {
//            // 如果 mask 只包含一个 1，即 mask 是 2 的幂
//            if ((mask & (mask - 1)) == 0) {
//                int u = Integer.bitCount((mask & (-mask)) - 1);
//                f[u][mask] = 0;
//            } else {
//                for (int u = 0; u < n; ++u) {
//                    if ((mask & (1 << u)) != 0) {
//                        for (int v = 0; v < n; ++v) {
//                            if ((mask & (1 << v)) != 0 && u != v) {
//                                f[u][mask] = Math.min(f[u][mask], f[v][mask ^ (1 << u)] + d[v][u]);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        int ans = Integer.MAX_VALUE;
//        for (int u = 0; u < n; ++u) {
//            ans = Math.min(ans, f[u][(1 << n) - 1]);
//        }
//        return ans;
//    }
}
