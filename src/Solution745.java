import java.util.HashMap;
import java.util.Map;

public class Solution745 {
    static class WordFilter {
        Map<String, Integer> dictionary;

        public WordFilter(String[] words) {
            dictionary = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int m = word.length();
                for (int prefixLength = 1; prefixLength <= m; prefixLength++) {
                    for (int suffixLength = 1; suffixLength <= m; suffixLength++) {
                        dictionary.put(word.substring(0, prefixLength) + "#" + word.substring(m - suffixLength), i);
                    }
                }
            }
        }

        public int f(String pref, String suff) {
            return dictionary.getOrDefault(pref + "#" + suff, -1);
        }
    }
}
