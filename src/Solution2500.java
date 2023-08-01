import java.util.Arrays;

public class Solution2500 {
    public int DeleteGreatestValue(int[][] grid) {
        int n = grid[0].length;
        for (int[] value : grid) {
            Arrays.sort(value);
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            int mx = 0;
            for (int[] ints : grid) {
                mx = Math.max(mx, ints[j]);
            }
            res += mx;
        }
        return res;
    }
}
