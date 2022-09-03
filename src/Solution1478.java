import java.util.Arrays;

public class Solution1478 {
    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);

        int[][] medSum = new int[n][n];
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                medSum[i][j] = medSum[i + 1][j - 1] + houses[j] - houses[i];
            }
        }

        int[][] f = new int[n][k + 1];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; ++i) {
            f[i][1] = medSum[0][i];
            for (int j = 2; j <= k && j <= i + 1; ++j) {
                for (int i0 = 0; i0 < i; ++i0) {
                    f[i][j] = Math.min(f[i][j], f[i0][j - 1] + medSum[i0 + 1][i]);
                }
            }
        }

        return f[n - 1][k];
    }
}
