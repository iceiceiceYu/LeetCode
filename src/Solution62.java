import java.math.BigInteger;

public class Solution62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
    }

    public static int uniquePaths(int m, int n) {
        BigInteger answer = BigInteger.ONE;
        for (int x = m + n - 2, y = 1; y < m; x--, y++) {
            answer = answer.multiply(BigInteger.valueOf(x)).divide(BigInteger.valueOf(y));
        }
        return answer.intValue();
//        long answer = 1;
//        for (int x = n, y = 1; y < m; x++, y++) {
//            answer = answer * x / y;
//        }
//        return (int) answer;
    }
}
