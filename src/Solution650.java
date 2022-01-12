public class Solution650 {
    public int minSteps(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                n /= i;
                ans += i;
            }
        }
        if (n > 1) {
            ans += n;
        }
        return ans;
    }

//    public int minSteps(int n) {
//        int[] f = new int[n + 1];
//        for (int i = 2; i <= n; ++i) {
//            f[i] = Integer.MAX_VALUE;
//            for (int j = 1; j * j <= i; ++j) {
//                if (i % j == 0) {
//                    f[i] = Math.min(f[i], f[j] + i / j);
//                    f[i] = Math.min(f[i], f[i / j] + j);
//                }
//            }
//        }
//        return f[n];
//    }
}
