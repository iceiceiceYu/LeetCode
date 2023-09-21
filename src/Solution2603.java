import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution2603 {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<>();
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
            ++degree[x];
            ++degree[y];
        }
        int rest = n;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1 && coins[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            --degree[u];
            --rest;
            for (int v : g[u]) {
                --degree[v];
                if (degree[v] == 1 && coins[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        for (int x = 0; x < 2; ++x) {
            queue = new ArrayDeque<Integer>();
            for (int i = 0; i < n; ++i) {
                if (degree[i] == 1) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int u = queue.poll();
                --degree[u];
                --rest;
                for (int v : g[u]) {
                    --degree[v];
                }
            }
        }
        return rest == 0 ? 0 : (rest - 1) * 2;
    }
}
