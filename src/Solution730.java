public class Solution730 {
    public int countPalindromicSubsequences(String s) {
        final int MOD = 1000000007;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    int low = i + 1;
                    int high = j - 1;
                    while (low <= high && s.charAt(low) != s.charAt(i)) {
                        low++;
                    }
                    while (high >= low && s.charAt(high) != s.charAt(j)) {
                        high--;
                    }
                    if (low > high) {
                        dp[i][j] = (2 + dp[i + 1][j - 1] * 2) % MOD;
                    } else if (low == high) {
                        dp[i][j] = (1 + dp[i + 1][j - 1] * 2) % MOD;
                    } else {
                        dp[i][j] = (dp[i + 1][j - 1] * 2 % MOD - dp[low + 1][high - 1] + MOD) % MOD;
                    }
                } else {
                    dp[i][j] = ((dp[i + 1][j] + dp[i][j - 1]) % MOD - dp[i + 1][j - 1] + MOD) % MOD;
                }
            }
        }

        return dp[0][n - 1];
    }
}
