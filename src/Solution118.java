import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            answer.add(compute(i));
        }
        return answer;
//        List<List<Integer>> answer = new ArrayList<>();
//        for (int i = 0; i < numRows; ++i) {
//            List<Integer> row = new ArrayList<>();
//            for (int j = 0; j <= i; ++j) {
//                if (j == 0 || j == i) {
//                    row.add(1);
//                } else {
//                    row.add(answer.get(i - 1).get(j - 1) + answer.get(i - 1).get(j));
//                }
//            }
//            answer.add(row);
//        }
//        return answer;
    }

    private static List<Integer> compute(int num) {
        List<Integer> list = new ArrayList<>();
        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;
        list.add(numerator.divide(denominator).intValue());
        for (int i = 1; i < num; i++) {
            numerator = numerator.multiply(BigInteger.valueOf(num - i));
            denominator = denominator.multiply(BigInteger.valueOf(i));
            list.add(numerator.divide(denominator).intValue());
        }
        return list;
    }
}
