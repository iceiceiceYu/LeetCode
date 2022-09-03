public class Solution1021 {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("()()"));
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int stack = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                stack--;
            }
            if (stack >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                stack++;
            }
        }
        return sb.toString();
    }
}
