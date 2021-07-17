import java.util.Arrays;

public class Solution1473 {
    // 极大值
    // 选择 Integer.MAX_VALUE / 2 的原因是防止整数相加溢出
    static final int INFINITY = Integer.MAX_VALUE / 2;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // 将颜色调整为从 0 开始编号，没有被涂色标记为 -1
        for (int i = 0; i < m; ++i) {
            --houses[i];
        }

        // dp 所有元素初始化为极大值
        int[][][] dp = new int[m][n][target];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], INFINITY);
            }
        }
        int[][][] best = new int[m][target][3];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < target; ++j) {
                best[i][j][0] = best[i][j][2] = INFINITY;
                best[i][j][1] = -1;
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (houses[i] != -1 && houses[i] != j) {
                    continue;
                }

                for (int k = 0; k < target; ++k) {
                    if (i == 0) {
                        if (k == 0) {
                            dp[i][j][k] = 0;
                        }
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                        if (k > 0) {
                            // 使用 best(i-1,k-1) 直接得到 dp(i,j,k) 的值
                            int first = best[i - 1][k - 1][0];
                            int firstIdx = best[i - 1][k - 1][1];
                            int second = best[i - 1][k - 1][2];
                            dp[i][j][k] = Math.min(dp[i][j][k], (j == firstIdx ? second : first));
                        }
                    }

                    if (dp[i][j][k] != INFINITY && houses[i] == -1) {
                        dp[i][j][k] += cost[i][j];
                    }

                    // 用 dp(i,j,k) 更新 best(i,k)
                    int first = best[i][k][0];
                    int firstIdx = best[i][k][1];
                    int second = best[i][k][2];
                    if (dp[i][j][k] < first) {
                        best[i][k][2] = first;
                        best[i][k][0] = dp[i][j][k];
                        best[i][k][1] = j;
                    } else if (dp[i][j][k] < second) {
                        best[i][k][2] = dp[i][j][k];
                    }
                }
            }
        }

        int ans = INFINITY;
        for (int j = 0; j < n; ++j) {
            ans = Math.min(ans, dp[m - 1][j][target - 1]);
        }
        return ans == INFINITY ? -1 : ans;
    }

//    // 极大值
//    // 选择 Integer.MAX_VALUE / 2 的原因是防止整数相加溢出
//    static final int INFINITY = Integer.MAX_VALUE / 2;
//
//    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
//        // 将颜色调整为从 0 开始编号，没有被涂色标记为 -1
//        for (int i = 0; i < m; ++i) {
//            --houses[i];
//        }
//
//        // dp 所有元素初始化为极大值
//        int[][][] dp = new int[m][n][target];
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                Arrays.fill(dp[i][j], INFINITY);
//            }
//        }
//
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (houses[i] != -1 && houses[i] != j) {
//                    continue;
//                }
//
//                for (int k = 0; k < target; ++k) {
//                    for (int j0 = 0; j0 < n; ++j0) {
//                        if (j == j0) {
//                            if (i == 0) {
//                                if (k == 0) {
//                                    dp[i][j][k] = 0;
//                                }
//                            } else {
//                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
//                            }
//                        } else if (i > 0 && k > 0) {
//                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j0][k - 1]);
//                        }
//                    }
//
//                    if (dp[i][j][k] != INFINITY && houses[i] == -1) {
//                        dp[i][j][k] += cost[i][j];
//                    }
//                }
//            }
//        }
//
//        int ans = INFINITY;
//        for (int j = 0; j < n; ++j) {
//            ans = Math.min(ans, dp[m - 1][j][target - 1]);
//        }
//        return ans == INFINITY ? -1 : ans;
//    }
}
