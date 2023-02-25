import java.util.Arrays;

public class Solution1210 {
    static final int INVALID = Integer.MAX_VALUE / 2;

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        int[][][] f = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(f[i][j], INVALID);
            }
        }
        f[0][0][0] = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                boolean canHorizontal = (j + 1 < n && grid[i][j] == 0 && grid[i][j + 1] == 0);
                boolean canVertical = (i + 1 < n && grid[i][j] == 0 && grid[i + 1][j] == 0);

                if (i - 1 >= 0 && canHorizontal) {
                    f[i][j][0] = Math.min(f[i][j][0], f[i - 1][j][0] + 1);
                }
                if (j - 1 >= 0 && canHorizontal) {
                    f[i][j][0] = Math.min(f[i][j][0], f[i][j - 1][0] + 1);
                }
                if (i - 1 >= 0 && canVertical) {
                    f[i][j][1] = Math.min(f[i][j][1], f[i - 1][j][1] + 1);
                }
                if (j - 1 >= 0 && canVertical) {
                    f[i][j][1] = Math.min(f[i][j][1], f[i][j - 1][1] + 1);
                }

                if (canHorizontal && canVertical && grid[i + 1][j + 1] == 0) {
                    f[i][j][0] = Math.min(f[i][j][0], f[i][j][1] + 1);
                    f[i][j][1] = Math.min(f[i][j][1], f[i][j][0] + 1);
                }
            }
        }

        return (f[n - 1][n - 2][0] == INVALID ? -1 : f[n - 1][n - 2][0]);
    }
}
