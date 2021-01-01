public class Solution1047 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String S) {
        String answer = S;
        StringBuilder sb = new StringBuilder(S);
        boolean isRemoved = false;
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                isRemoved = true;
            }
        }
        if (isRemoved) {
            answer = removeDuplicates(sb.toString());
        }
        return answer;
    }
}
