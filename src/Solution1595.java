import java.util.Arrays;
import java.util.List;

public class Solution1595 {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int size1 = cost.size(), size2 = cost.get(0).size(), m = 1 << size2;
        int[] dp1 = new int[m];
        Arrays.fill(dp1, Integer.MAX_VALUE / 2);
        int[] dp2 = new int[m];
        dp1[0] = 0;
        for (int i = 1; i <= size1; i++) {
            for (int s = 0; s < m; s++) {
                dp2[s] = Integer.MAX_VALUE / 2;
                for (int k = 0; k < size2; k++) {
                    if ((s & (1 << k)) == 0) {
                        continue;
                    }
                    dp2[s] = Math.min(dp2[s], dp2[s ^ (1 << k)] + cost.get(i - 1).get(k));
                    dp2[s] = Math.min(dp2[s], dp1[s] + cost.get(i - 1).get(k));
                    dp2[s] = Math.min(dp2[s], dp1[s ^ (1 << k)] + cost.get(i - 1).get(k));
                }
            }
            System.arraycopy(dp2, 0, dp1, 0, m);
        }
        return dp1[m - 1];
    }
}
