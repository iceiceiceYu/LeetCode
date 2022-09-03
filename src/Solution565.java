public class Solution565 {
    public int arrayNesting(int[] nums) {
        int ans = 0, n = nums.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            while (!vis[i]) {
                vis[i] = true;
                i = nums[i];
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
