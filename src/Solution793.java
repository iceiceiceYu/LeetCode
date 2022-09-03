public class Solution793 {
    public int preimageSizeFZF(int k) {
        return (int) (help(k + 1) - help(k));
    }

    private long help(int k) {
        long r = 5L * k;
        long l = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (zeta(mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r + 1;
    }

    private long zeta(long x) {
        long res = 0;
        while (x != 0) {
            res += x / 5;
            x /= 5;
        }
        return res;
    }
}
