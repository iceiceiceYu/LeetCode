public class Solution233 {
    public int countDigitOne(int n) {
        // mul 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mul = 1;
        int ans = 0;
        for (int k = 0; n >= mul; k++) {
            ans += (n / (mul * 10)) * mul + Math.min(Math.max(n % (mul * 10) - mul + 1, 0), mul);
            mul *= 10;
        }
        return ans;
    }
}
