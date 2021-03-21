import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] != e2[0]) {
                return e1[0] - e2[0];
            } else {
                return e2[1] - e1[1];
            }
        });

        List<Integer> f = new ArrayList<>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
//    public int maxEnvelopes(int[][] envelopes) {
//        if (envelopes.length == 0) {
//            return 0;
//        }
//
//        int n = envelopes.length;
//        Arrays.sort(envelopes, (e1, e2) -> {
//            if (e1[0] != e2[0]) {
//                return e1[0] - e2[0];
//            } else {
//                return e2[1] - e1[1];
//            }
//        });
//
//        int[] f = new int[n];
//        Arrays.fill(f, 1);
//        int ans = 1;
//        for (int i = 1; i < n; ++i) {
//            for (int j = 0; j < i; ++j) {
//                if (envelopes[j][1] < envelopes[i][1]) {
//                    f[i] = Math.max(f[i], f[j] + 1);
//                }
//            }
//            ans = Math.max(ans, f[i]);
//        }
//        return ans;
//    }
}
