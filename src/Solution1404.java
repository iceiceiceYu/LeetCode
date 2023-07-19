public class Solution1404 {
    public int numSteps(String s) {
        int n = s.length();
        int ans = 0;
        boolean meet1 = false;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                ans += (meet1 ? 2 : 1);
            } else {
                if (!meet1) {
                    if (i != 0) {
                        ans += 2;
                    }
                    meet1 = true;
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }
}
