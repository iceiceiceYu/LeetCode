public class Solution58 {
    public int lengthOfLastWord(String s) {
//        int end = s.length() - 1;
//        while (end >= 0 && s.charAt(end) == ' ') {
//            end--;
//        }
//        if (end < 0) {
//            return 0;
//        }
//        int start = end;
//        while (start >= 0 && s.charAt(start) != ' ') {
//            start--;
//        }
//        return end - start;
        String[] split = s.split(" ");
        if (split.length == 0) {
            return 0;
        }
        return split[split.length - 1].length();
    }
}
