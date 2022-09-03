import java.util.HashSet;
import java.util.Set;

public class Solution824 {
    public String toGoatLatin(String sentence) {
        Set<Character> vowels = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};

        int n = sentence.length();
        int i = 0, cnt = 1;
        StringBuilder ans = new StringBuilder();

        while (i < n) {
            int j = i;
            while (j < n && sentence.charAt(j) != ' ') {
                ++j;
            }

            ++cnt;
            if (cnt != 2) {
                ans.append(' ');
            }
            if (vowels.contains(sentence.charAt(i))) {
                ans.append(sentence, i, j);
            } else {
                ans.append(sentence, i + 1, j);
                ans.append(sentence.charAt(i));
            }
            ans.append('m');
            for (int k = 0; k < cnt; ++k) {
                ans.append('a');
            }

            i = j + 1;
        }

        return ans.toString();
    }
}
