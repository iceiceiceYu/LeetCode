public class Solution1221 {
    public int balancedStringSplit(String s) {
        int ans = 0, d = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                d++;
            } else {
                d--;
            }
            if (d == 0) {
                ans++;
            }
        }
        return ans;
    }
}
