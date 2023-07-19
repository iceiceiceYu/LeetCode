import java.util.Arrays;

public class Solution2611 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = 0;
        int n = reward1.length;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            diffs[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diffs);
        for (int i = 1; i <= k; i++) {
            ans += diffs[n - i];
        }
        return ans;
    }
}
