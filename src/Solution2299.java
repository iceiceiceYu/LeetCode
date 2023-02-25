import java.util.HashSet;
import java.util.Set;

public class Solution2299 {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }

        Set<Character> specials = new HashSet<Character>() {{
            add('!');
            add('@');
            add('#');
            add('$');
            add('%');
            add('^');
            add('&');
            add('*');
            add('(');
            add(')');
            add('-');
            add('+');
        }};
        int n = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
        for (int i = 0; i < n; ++i) {
            if (i != n - 1 && password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }

            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (specials.contains(ch)) {
                hasSpecial = true;
            }
        }

        return hasLower && hasUpper && hasDigit && hasSpecial;
    }
}
