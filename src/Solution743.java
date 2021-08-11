import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<>();
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x].add(new int[]{y, t[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        pq.offer(new int[]{k - 1, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int x = p[0], time = p[1];
            if (dist[x] < time) {
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0], d = dist[x] + e[1];
                if (d < dist[y]) {
                    dist[y] = d;
                    pq.offer(new int[]{y, d});
                }
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }

//    public int networkDelayTime(int[][] times, int n, int k) {
//        final int INF = Integer.MAX_VALUE / 2;
//        int[][] g = new int[n][n];
//        for (int i = 0; i < n; ++i) {
//            Arrays.fill(g[i], INF);
//        }
//        for (int[] t : times) {
//            int x = t[0] - 1, y = t[1] - 1;
//            g[x][y] = t[2];
//        }
//
//        int[] dist = new int[n];
//        Arrays.fill(dist, INF);
//        dist[k - 1] = 0;
//        boolean[] used = new boolean[n];
//        for (int i = 0; i < n; ++i) {
//            int x = -1;
//            for (int y = 0; y < n; ++y) {
//                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
//                    x = y;
//                }
//            }
//            used[x] = true;
//            for (int y = 0; y < n; ++y) {
//                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
//            }
//        }
//
//        int ans = Arrays.stream(dist).max().getAsInt();
//        return ans == INF ? -1 : ans;
//    }
}
