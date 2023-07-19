import java.util.*;

public class Solution1681 {
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length, group = n / k, inf = Integer.MAX_VALUE;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, inf);
        dp[0] = 0;
        HashMap<Integer, Integer> values = new HashMap<>();

        for (int mask = 1; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) != group) {
                continue;
            }
            int mn = 20, mx = 0;
            HashSet<Integer> cur = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    if (cur.contains(nums[i])) {
                        break;
                    }
                    cur.add(nums[i]);
                    mn = Math.min(mn, nums[i]);
                    mx = Math.max(mx, nums[i]);
                }
            }
            if (cur.size() == group) {
                values.put(mask, mx - mn);
            }
        }

        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == inf) {
                continue;
            }
            HashMap<Integer, Integer> seen = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    seen.put(nums[i], i);
                }
            }
            if (seen.size() < group) {
                continue;
            }
            int sub = 0;
            for (int v : seen.values()) {
                sub |= (1 << v);
            }
            int nxt = sub;
            while (nxt > 0) {
                if (values.containsKey(nxt)) {
                    dp[mask | nxt] = Math.min(dp[mask | nxt], dp[mask] + values.get(nxt));
                }
                nxt = (nxt - 1) & sub;
            }
        }

        return (dp[(1 << n) - 1] < inf) ? dp[(1 << n) - 1] : -1;
    }
}
