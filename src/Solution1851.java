import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1851 {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Integer[] qIndex = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            qIndex[i] = i;
        }
        Arrays.sort(qIndex, Comparator.comparingInt(i -> queries[i]));
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        int i = 0;
        for (int qi : qIndex) {
            while (i < intervals.length && intervals[i][0] <= queries[qi]) {
                pq.offer(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][0], intervals[i][1]});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[2] < queries[qi]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                res[qi] = pq.peek()[0];
            }
        }
        return res;
    }
}
