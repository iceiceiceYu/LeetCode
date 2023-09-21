import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1782 {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] degree = new int[n];
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            degree[x]++;
            degree[y]++;
            cnt.put(x * n + y, cnt.getOrDefault(x * n + y, 0) + 1);
        }

        int[] arr = Arrays.copyOf(degree, n);
        int[] ans = new int[queries.length];
        Arrays.sort(arr);
        for (int k = 0; k < queries.length; k++) {
            int bound = queries[k], total = 0;
            for (int i = 0, j = n - 1; i < n; i++) {
                while (j > i && arr[i] + arr[j] > bound) {
                    j--;
                }
                total += n - 1 - Math.max(i, j);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int val = entry.getKey(), freq = entry.getValue();
                int x = val / n, y = val % n;
                if (degree[x] + degree[y] > bound && degree[x] + degree[y] - freq <= bound) {
                    total--;
                }
            }
            ans[k] = total;
        }

        return ans;
    }
}
