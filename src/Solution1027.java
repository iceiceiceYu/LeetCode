import java.util.Arrays;

public class Solution1027 {
    public int longestArithSeqLength(int[] nums) {
        int minV = Arrays.stream(nums).min().getAsInt();
        int maxV = Arrays.stream(nums).max().getAsInt();
        int diff = maxV - minV;
        int ans = 1;
        for (int d = -diff; d <= diff; ++d) {
            int[] f = new int[maxV + 1];
            Arrays.fill(f, -1);
            for (int num : nums) {
                int prev = num - d;
                if (prev >= minV && prev <= maxV && f[prev] != -1) {
                    f[num] = Math.max(f[num], f[prev] + 1);
                    ans = Math.max(ans, f[num]);
                }
                f[num] = Math.max(f[num], 1);
            }
        }
        return ans;
    }
}
