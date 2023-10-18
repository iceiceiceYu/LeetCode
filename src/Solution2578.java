import java.util.Arrays;

public class Solution2578 {
    public int splitNum(int num) {
        char[] stNum = Integer.toString(num).toCharArray();
        Arrays.sort(stNum);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < stNum.length; ++i) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + (stNum[i] - '0');
            } else {
                num2 = num2 * 10 + (stNum[i] - '0');
            }
        }
        return num1 + num2;
    }
}
