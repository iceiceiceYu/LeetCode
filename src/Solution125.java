public class Solution125 {
    public boolean isPalindrome(String s) {
//        StringBuilder good = new StringBuilder();
//        int length = s.length();
//        for (int i = 0; i < length; i++) {
//            char ch = s.charAt(i);
//            if (Character.isLetterOrDigit(ch)) {
//                good.append(Character.toLowerCase(ch));
//            }
//        }
//        StringBuilder goodRev = new StringBuilder(good).reverse();
//        return good.toString().equals(goodRev.toString());

//        StringBuilder good = new StringBuilder();
//        int length = s.length();
//        for (int i = 0; i < length; i++) {
//            char ch = s.charAt(i);
//            if (Character.isLetterOrDigit(ch)) {
//                good.append(Character.toLowerCase(ch));
//            }
//        }
//        int n = good.length();
//        int left = 0, right = n - 1;
//        while (left < right) {
//            if (Character.toLowerCase(good.charAt(left)) != Character.toLowerCase(good.charAt(right))) {
//                return false;
//            }
//            ++left;
//            --right;
//        }
//        return true;

        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
