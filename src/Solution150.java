import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
//        Deque<Integer> stack = new LinkedList<>();
        int n = tokens.length;
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }

//    public int evalRPN(String[] tokens) {
//        int n = tokens.length;
//        int[] stack = new int[(n + 1) / 2];
//        int index = -1;
//        for (int i = 0; i < n; i++) {
//            String token = tokens[i];
//            switch (token) {
//                case "+":
//                    index--;
//                    stack[index] += stack[index + 1];
//                    break;
//                case "-":
//                    index--;
//                    stack[index] -= stack[index + 1];
//                    break;
//                case "*":
//                    index--;
//                    stack[index] *= stack[index + 1];
//                    break;
//                case "/":
//                    index--;
//                    stack[index] /= stack[index + 1];
//                    break;
//                default:
//                    index++;
//                    stack[index] = Integer.parseInt(token);
//            }
//        }
//        return stack[index];
//    }
}
