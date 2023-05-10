public class Solution2432 {
    public int hardestWorker(int n, int[][] logs) {
        int ans = logs[0][0], maxCost = logs[0][1];
        for (int i = 1; i < logs.length; ++i) {
            int idx = logs[i][0];
            int cost = logs[i][1] - logs[i - 1][1];
            if (cost > maxCost || (cost == maxCost && idx < ans)) {
                ans = idx;
                maxCost = cost;
            }
        }
        return ans;
    }
}
