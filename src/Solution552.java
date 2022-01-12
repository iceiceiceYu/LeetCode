import java.util.Arrays;

public class Solution552 {
    static final int MOD = 1000000007;

    public int checkRecord(int n) {
        long[][] mat = {{1, 1, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0}};
        long[][] res = pow(mat, n);
        long sum = Arrays.stream(res[0]).sum();
        return (int) (sum % MOD);
    }

    private long[][] pow(long[][] mat, int n) {
        long[][] ret = {{1, 0, 0, 0, 0, 0}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, mat);
            }
            n >>= 1;
            mat = multiply(mat, mat);
        }
        return ret;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int rows = a.length, columns = b[0].length, temp = b.length;
        long[][] c = new long[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < temp; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                    c[i][j] %= MOD;
                }
            }
        }
        return c;
    }

//    public int checkRecord(int n) {
//        final int MOD = 1000000007;
//        int[][] dp = new int[2][3]; // A 的数量，结尾连续 L 的数量
//        dp[0][0] = 1;
//        for (int i = 1; i <= n; i++) {
//            int[][] dpNew = new int[2][3];
//            // 以 P 结尾的数量
//            for (int j = 0; j <= 1; j++) {
//                for (int k = 0; k <= 2; k++) {
//                    dpNew[j][0] = (dpNew[j][0] + dp[j][k]) % MOD;
//                }
//            }
//            // 以 A 结尾的数量
//            for (int k = 0; k <= 2; k++) {
//                dpNew[1][0] = (dpNew[1][0] + dp[0][k]) % MOD;
//            }
//            // 以 L 结尾的数量
//            for (int j = 0; j <= 1; j++) {
//                for (int k = 1; k <= 2; k++) {
//                    dpNew[j][k] = (dpNew[j][k] + dp[j][k - 1]) % MOD;
//                }
//            }
//            dp = dpNew;
//        }
//        int sum = 0;
//        for (int j = 0; j <= 1; j++) {
//            for (int k = 0; k <= 2; k++) {
//                sum = (sum + dp[j][k]) % MOD;
//            }
//        }
//        return sum;
//    }
}
