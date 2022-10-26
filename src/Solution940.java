public class Solution940 {
    public int distinctSubseqII(String s) {
        final int MOD = 1000000007;
        int[] g = new int[26];
        int n = s.length(), total = 0;
        for (int i = 0; i < n; ++i) {
            int oi = s.charAt(i) - 'a';
            int prev = g[oi];
            g[oi] = (total + 1) % MOD;
            total = ((total + g[oi] - prev) % MOD + MOD) % MOD;
        }
        return total;
    }
}
