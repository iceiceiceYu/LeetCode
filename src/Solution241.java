import java.util.ArrayList;
import java.util.List;

public class Solution241 {
    static final int ADDITION = -1;
    static final int SUBTRACTION = -2;
    static final int MULTIPLICATION = -3;

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ops = new ArrayList<>();
        for (int i = 0; i < expression.length();) {
            if (!Character.isDigit(expression.charAt(i))) {
                if (expression.charAt(i) == '+') {
                    ops.add(ADDITION);
                } else if (expression.charAt(i) == '-') {
                    ops.add(SUBTRACTION);
                } else {
                    ops.add(MULTIPLICATION);
                }
                i++;
            } else {
                int t = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    t = t * 10 + expression.charAt(i) - '0';
                    i++;
                }
                ops.add(t);
            }
        }
        List<Integer>[][] dp = new List[ops.size()][ops.size()];
        for (int i = 0; i < ops.size(); i++) {
            for (int j = 0; j < ops.size(); j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < ops.size(); i += 2) {
            dp[i][i].add(ops.get(i));
        }
        for (int i = 3; i <= ops.size(); i++) {
            for (int j = 0; j + i <= ops.size(); j += 2) {
                int l = j;
                int r = j + i - 1;
                for (int k = j + 1; k < r; k += 2) {
                    List<Integer> left = dp[l][k - 1];
                    List<Integer> right = dp[k + 1][r];
                    for (int num1 : left) {
                        for (int num2 : right) {
                            if (ops.get(k) == ADDITION) {
                                dp[l][r].add(num1 + num2);
                            } else if (ops.get(k) == SUBTRACTION) {
                                dp[l][r].add(num1 - num2);
                            } else if (ops.get(k) == MULTIPLICATION) {
                                dp[l][r].add(num1 * num2);
                            }
                        }
                    }
                }
            }
        }
        return dp[0][ops.size() - 1];
    }
}
