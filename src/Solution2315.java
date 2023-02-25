public class Solution2315 {
    public int countAsterisks(String s) {
        boolean valid = true;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                valid = !valid;
            } else if (c == '*' && valid) {
                res++;
            }
        }
        return res;
    }
}
