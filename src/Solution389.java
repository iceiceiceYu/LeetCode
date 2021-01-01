public class Solution389 {
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
        System.out.println(findTheDifference("", "y"));
        System.out.println(findTheDifference("a", "aa"));
        System.out.println(findTheDifference("ae", "aea"));
    }

    public static char findTheDifference(String s, String t) {
        int ret = 0;
        for (char ch : s.toCharArray()) {
            ret ^= ch;
        }
        for (char ch : t.toCharArray()) {
            ret ^= ch;
        }
        return (char) ret;
//        int as = 0, at = 0;
//        for (char ch : s.toCharArray()) {
//            as += ch;
//        }
//        for (char ch : t.toCharArray()) {
//            at += ch;
//        }
//        return (char) (at - as);
//        int[] cnt = new int[26];
//        for (char ch : s.toCharArray()) {
//            cnt[ch - 'a']++;
//        }
//        for (char ch : t.toCharArray()) {
//            cnt[ch - 'a']--;
//            if (cnt[ch - 'a'] < 0) {
//                return ch;
//            }
//        }
//        return ' ';
    }
}
