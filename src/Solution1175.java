public class Solution1175 {
    static final int MOD = 1000000007;

    public int numPrimeArrangements(int n) {
        int numPrimes = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                numPrimes++;
            }
        }
        return (int) (factorial(numPrimes) * factorial(n - numPrimes) % MOD);
    }

    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res %= MOD;
        }
        return res;
    }
}
