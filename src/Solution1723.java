import java.util.Arrays;

public class Solution1723 {
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int low = 0, high = jobs.length - 1;
        while (low < high) {
            int temp = jobs[low];
            jobs[low] = jobs[high];
            jobs[high] = temp;
            low++;
            high--;
        }
        int l = jobs[0], r = Arrays.stream(jobs).sum();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(jobs, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] jobs, int k, int limit) {
        int[] workloads = new int[k];
        return backtrack(jobs, workloads, 0, limit);
    }

    public boolean backtrack(int[] jobs, int[] workloads, int i, int limit) {
        if (i >= jobs.length) {
            return true;
        }
        int cur = jobs[i];
        for (int j = 0; j < workloads.length; ++j) {
            if (workloads[j] + cur <= limit) {
                workloads[j] += cur;
                if (backtrack(jobs, workloads, i + 1, limit)) {
                    return true;
                }
                workloads[j] -= cur;
            }
            // 如果当前工人未被分配工作，那么下一个工人也必然未被分配工作
            // 或者当前工作恰能使该工人的工作量达到了上限
            // 这两种情况下我们无需尝试继续分配工作
            if (workloads[j] == 0 || workloads[j] + cur == limit) {
                break;
            }
        }
        return false;
    }

//    public int minimumTimeRequired(int[] jobs, int k) {
//        int n = jobs.length;
//        int[] sum = new int[1 << n];
//        for (int i = 1; i < (1 << n); i++) {
//            int x = Integer.numberOfTrailingZeros(i), y = i - (1 << x);
//            sum[i] = sum[y] + jobs[x];
//        }
//
//        int[][] dp = new int[k][1 << n];
//        if ((1 << n) >= 0) {
//            System.arraycopy(sum, 0, dp[0], 0, (1 << n));
//        }
//
//        for (int i = 1; i < k; i++) {
//            for (int j = 0; j < (1 << n); j++) {
//                int minn = Integer.MAX_VALUE;
//                for (int x = j; x != 0; x = (x - 1) & j) {
//                    minn = Math.min(minn, Math.max(dp[i - 1][j - x], sum[x]));
//                }
//                dp[i][j] = minn;
//            }
//        }
//        return dp[k - 1][(1 << n) - 1];
//    }
}
