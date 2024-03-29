public class Solution2496 {
    public int maximumValue(String[] strs) {
        int res = 0;
        for (String s : strs) {
            boolean isDigits = true;
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                isDigits &= Character.isDigit(s.charAt(i));
            }
            res = Math.max(res, isDigits ? Integer.parseInt(s) : n);
        }
        return res;
    }
}
