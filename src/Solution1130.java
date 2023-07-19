import java.util.Arrays;

public class Solution1130 {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 4);
        }
        int[][] val = new int[n][n];
        for (int j = 0; j < n; j++) {
            val[j][j] = arr[j];
            dp[j][j] = 0;
            for (int i = j - 1; i >= 0; i--) {
                val[i][j] = Math.max(arr[i], val[i + 1][j]);
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + val[i][k] * val[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
