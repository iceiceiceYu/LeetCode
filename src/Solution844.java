public class Solution844 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));
    }

    public static boolean backspaceCompare(String S, String T) {
        StringBuilder sbS = new StringBuilder();
        StringBuilder sbT = new StringBuilder();
        return modify(sbS, S).equals(modify(sbT, T));
    }

    private static String modify(StringBuilder sb, String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c != '#') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }
}
