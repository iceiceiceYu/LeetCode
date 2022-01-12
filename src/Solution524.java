import java.util.Arrays;
import java.util.List;

public class Solution524 {
    public String findLongestWord(String s, List<String> dictionary) {
        int m = s.length();
        int[][] f = new int[m + 1][26];
        Arrays.fill(f[m], m);

        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < 26; ++j) {
                if (s.charAt(i) == (char) ('a' + j)) {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        String res = "";
        for (String t : dictionary) {
            boolean match = true;
            int j = 0;
            for (int i = 0; i < t.length(); ++i) {
                if (f[j][t.charAt(i) - 'a'] == m) {
                    match = false;
                    break;
                }
                j = f[j][t.charAt(i) - 'a'] + 1;
            }
            if (match) {
                if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }

//    public String findLongestWord(String s, List<String> dictionary) {
//        dictionary.sort((word1, word2) -> {
//            if (word1.length() != word2.length()) {
//                return word2.length() - word1.length();
//            } else {
//                return word1.compareTo(word2);
//            }
//        });
//        for (String t : dictionary) {
//            int i = 0, j = 0;
//            while (i < t.length() && j < s.length()) {
//                if (t.charAt(i) == s.charAt(j)) {
//                    ++i;
//                }
//                ++j;
//            }
//            if (i == t.length()) {
//                return t;
//            }
//        }
//        return "";
//    }

//    public String findLongestWord(String s, List<String> dictionary) {
//        String res = "";
//        for (String t : dictionary) {
//            int i = 0, j = 0;
//            while (i < t.length() && j < s.length()) {
//                if (t.charAt(i) == s.charAt(j)) {
//                    ++i;
//                }
//                ++j;
//            }
//            if (i == t.length()) {
//                if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
//                    res = t;
//                }
//            }
//        }
//        return res;
//    }
}
