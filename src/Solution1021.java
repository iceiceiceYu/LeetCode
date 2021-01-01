public class Solution1021 {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("()()"));
    }

    public static String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int stack = 0;
        for (char c : S.toCharArray()) {
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

//        StringBuilder sb = new StringBuilder();
//        int stack = 0;
//        int first = 0, last = 0;
//
//        for (char c : S.toCharArray()) {
//            if (c == '(') {
//                stack++;
//                last++;
//            } else {
//                stack--;
//                last++;
//                if (stack == 0) {
//                    sb.append(S, first + 1, last - 1);
//                    first = last;
//                }
//            }
//        }
//        return sb.toString();
    }
}
