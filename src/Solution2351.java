import java.util.HashSet;
import java.util.Set;

public class Solution2351 {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!set.add(c)) {
                return c;
            }
        }
        return ' ';
    }
}
