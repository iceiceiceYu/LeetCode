import java.util.Stack;

public class CodingInterview16_26 {
    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate(" 3+5 / 2 "));
    }

    public static int calculate(String s) {
        char[] chars = s.replace(" ", "").toCharArray();
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int i = 0;
        while (i < chars.length) {
            char temp = chars[i];
            if (temp == '*' || temp == '/' || temp == '+' || temp == '-') {
                i++;
            }
            int num = 0;
            while (i < chars.length && Character.isDigit(chars[i])) {
                num = num * 10 + chars[i] - '0';
                i++;
            }
            switch (temp) {
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = stack.pop() * num;
                    break;
                case '/':
                    num = stack.pop() / num;
                    break;
                default:
                    break;
            }
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }
}
