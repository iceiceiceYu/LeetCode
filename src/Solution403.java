public class Solution403 {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }

//    private Boolean[][] rec;
//
//    public boolean canCross(int[] stones) {
//        int n = stones.length;
//        rec = new Boolean[n][n];
//        return dfs(stones, 0, 0);
//    }
//
//    private boolean dfs(int[] stones, int i, int lastDis) {
//        if (i == stones.length - 1) {
//            return true;
//        }
//        if (rec[i][lastDis] != null) {
//            return rec[i][lastDis];
//        }
//
//        for (int curDis = lastDis - 1; curDis <= lastDis + 1; curDis++) {
//            if (curDis > 0) {
//                int j = Arrays.binarySearch(stones, i + 1, stones.length, curDis + stones[i]);
//                if (j >= 0 && dfs(stones, j, curDis)) {
//                    return rec[i][lastDis] = true;
//                }
//            }
//        }
//        return rec[i][lastDis] = false;
//    }
}
