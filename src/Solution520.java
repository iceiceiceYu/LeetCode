public class Solution520 {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("FlaG"));
    }

    public static boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }
        char[] chars = word.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] < 'a' || chars[i] > 'z') {
                    return false;
                }
            }
            return true;
        } else {
            if (chars[1] >= 'A' && chars[1] <= 'Z') {
                for (int i = 2; i < chars.length; i++) {
                    if (chars[i] < 'A' || chars[i] > 'Z') {
                        return false;
                    }
                }
                return true;
            } else {
                for (int i = 2; i < chars.length; i++) {
                    if (chars[i] < 'a' || chars[i] > 'z') {
                        return false;
                    }
                }
                return true;
            }
        }
//        int length = word.length();
//        int count = 0;
//        for (int i = 0; i < length; i++) {
//            char s = word.charAt(i);
//            if (s >= 'A' && s <= 'Z') {
//                count++;
//            }
//        }
//        return count == length || count == 0 || (count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');
    }
}
