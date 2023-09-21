import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1761 {
    public int minTrioDegree(int n, int[][] edges) {
        Set<Integer>[] g = new Set[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new HashSet<>();
        }
        List<Integer>[] h = new List[n];
        for (int i = 0; i < n; ++i) {
            h[i] = new ArrayList<>();
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            g[x].add(y);
            g[y].add(x);
            ++degree[x];
            ++degree[y];
        }
        for (int[] edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            if (degree[x] < degree[y] || (degree[x] == degree[y] && x < y)) {
                h[x].add(y);
            } else {
                h[y].add(x);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j : h[i]) {
                for (int k : h[j]) {
                    if (g[i].contains(k)) {
                        ans = Math.min(ans, degree[i] + degree[j] + degree[k] - 6);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
