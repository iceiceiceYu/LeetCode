import java.util.Arrays;
import java.util.Random;

public class Solution1147 {
    long[] pre1;
    long[] pre2;
    long[] pow1;
    long[] pow2;
    static final int MOD1 = 1000000007;
    static final int MOD2 = 1000000009;
    int base1, base2;
    Random random = new Random();

    public int longestDecomposition(String text) {
        init(text);
        int n = text.length();
        int res = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            int len = 1;
            while (l + len - 1 < r - len + 1) {
                if (Arrays.equals(getHash(l, l + len - 1), getHash(r - len + 1, r))) {
                    res += 2;
                    break;
                }
                ++len;
            }
            if (l + len - 1 >= r - len + 1) {
                ++res;
            }
            l += len;
            r -= len;
        }
        return res;
    }

    private void init(String s) {
        base1 = 1000000 + random.nextInt(9000000);
        base2 = 1000000 + random.nextInt(9000000);
        while (base2 == base1) {
            base2 = 1000000 + random.nextInt(9000000);
        }
        int n = s.length();
        pow1 = new long[n];
        pow2 = new long[n];
        pre1 = new long[n + 1];
        pre2 = new long[n + 1];
        pow1[0] = pow2[0] = 1;
        pre1[1] = pre2[1] = s.charAt(0);
        for (int i = 1; i < n; i++) {
            pow1[i] = (pow1[i - 1] * base1) % MOD1;
            pow2[i] = (pow2[i - 1] * base2) % MOD2;
            pre1[i + 1] = (pre1[i] * base1 + s.charAt(i)) % MOD1;
            pre2[i + 1] = (pre2[i] * base2 + s.charAt(i)) % MOD2;
        }
    }

    private long[] getHash(int l, int r) {
        return new long[]{(pre1[r + 1] - ((pre1[l] * pow1[r + 1 - l]) % MOD1) + MOD1) % MOD1, (pre2[r + 1] - ((pre2[l] * pow2[r + 1 - l]) % MOD2) + MOD2) % MOD2};
    }
}
