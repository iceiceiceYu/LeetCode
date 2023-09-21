import java.util.HashMap;
import java.util.Map;

public class Solution980 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Map<Integer, Integer> memo = new HashMap<>();

    public int uniquePathsIII(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int si = 0, sj = 0, st = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 2) {
                    st |= 1 << (i * c + j);
                } else if (grid[i][j] == 1) {
                    si = i;
                    sj = j;
                }
            }
        }
        return dp(grid, si, sj, st);
    }

    private int dp(int[][] grid, int i, int j, int st) {
        if (grid[i][j] == 2) {
            return st == 0 ? 1 : 0;
        }
        int r = grid.length, c = grid[0].length;
        int key = ((i * c + j) << (r * c)) + st;
        if (!memo.containsKey(key)) {
            int res = 0;
            for (int[] dir : dirs) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni >= 0 && ni < r && nj >= 0 && nj < c && (st & (1 << (ni * c + nj))) > 0) {
                    res += dp(grid, ni, nj, st ^ (1 << (ni * c + nj)));
                }
            }
            memo.put(key, res);
        }
        return memo.get(key);
    }
}
