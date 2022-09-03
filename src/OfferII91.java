import java.util.Arrays;

public class OfferII91 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[] dp = new int[3];
        System.arraycopy(costs[0], 0, dp, 0, 3);
        for (int i = 1; i < n; i++) {
            int[] dpNew = new int[3];
            for (int j = 0; j < 3; j++) {
                dpNew[j] = Math.min(dp[(j + 1) % 3], dp[(j + 2) % 3]) + costs[i][j];
            }
            dp = dpNew;
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
