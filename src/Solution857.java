import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] h = new Integer[n];
        for (int i = 0; i < n; i++) {
            h[i] = i;
        }
        Arrays.sort(h, (a, b) -> quality[b] * wage[a] - quality[a] * wage[b]);
        double res = 1e9;
        double totalQ = 0.0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k - 1; i++) {
            totalQ += quality[h[i]];
            pq.offer(quality[h[i]]);
        }
        for (int i = k - 1; i < n; i++) {
            int idx = h[i];
            totalQ += quality[idx];
            pq.offer(quality[idx]);
            double totalC = ((double) wage[idx] / quality[idx]) * totalQ;
            res = Math.min(res, totalC);
            totalQ -= pq.poll();
        }
        return res;
    }
}
