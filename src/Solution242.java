import java.util.Arrays;

public class Solution242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Arrays.sort(charsS);
        Arrays.sort(charsT);
        return Arrays.equals(charsS, charsT);

//        if (s.length() != t.length()) {
//            return false;
//        }
//        int[] table = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            table[s.charAt(i) - 'a']++;
//        }
//        for (int i = 0; i < t.length(); i++) {
//            table[t.charAt(i) - 'a']--;
//            if (table[t.charAt(i) - 'a'] < 0) {
//                return false;
//            }
//        }
//        return true;

//        if (s.length() != t.length()) {
//            return false;
//        }
//        int[] counter = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            counter[s.charAt(i) - 'a']++;
//            counter[t.charAt(i) - 'a']--;
//        }
//        for (int count : counter) {
//            if (count != 0) {
//                return false;
//            }
//        }
//        return true;
    }
}
