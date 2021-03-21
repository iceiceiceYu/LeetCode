import java.util.Arrays;
import java.util.Comparator;

public class Solution435 {
    //    public int eraseOverlapIntervals(int[][] intervals) {
//        if (intervals.length == 0) {
//            return 0;
//        }
//
//        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
//
//        int n = intervals.length;
//        int[] f = new int[n];
//        Arrays.fill(f, 1);
//        for (int i = 1; i < n; ++i) {
//            for (int j = 0; j < i; ++j) {
//                if (intervals[j][1] <= intervals[i][0]) {
//                    f[i] = Math.max(f[i], f[j] + 1);
//                }
//            }
//        }
//        return n - Arrays.stream(f).max().getAsInt();
//    }
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}
