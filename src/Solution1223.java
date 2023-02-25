public class Solution1223 {
    static final int MOD = 1000000007;

    public int dieSimulator(int n, int[] rollMax) {
        int[][] d = new int[n + 1][6];
        int[] sum = new int[n + 1];
        sum[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                int pos = Math.max(i - rollMax[j] - 1, 0);
                int sub = ((sum[pos] - d[pos][j]) % MOD + MOD) % MOD;
                d[i][j] = ((sum[i - 1] - sub) % MOD + MOD) % MOD;
                if (i <= rollMax[j]) {
                    d[i][j] = (d[i][j] + 1) % MOD;
                }
                sum[i] = (sum[i] + d[i][j]) % MOD;
            }
        }
        return sum[n];
    }
}
