import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Map<Integer, int[]> candidates = new HashMap<>();
        int kx = king[0], ky = king[1];
        for (int[] queen : queens) {
            int qx = queen[0], qy = queen[1];
            int x = qx - kx, y = qy - ky;
            if (x == 0 || y == 0 || Math.abs(x) == Math.abs(y)) {
                int dx = sgn(x), dy = sgn(y);
                int key = dx * 10 + dy;
                if (!candidates.containsKey(key) || candidates.get(key)[2] > Math.abs(x) + Math.abs(y)) {
                    candidates.put(key, new int[]{queen[0], queen[1], Math.abs(x) + Math.abs(y)});
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, int[]> entry : candidates.entrySet()) {
            int[] value = entry.getValue();
            List<Integer> posList = new ArrayList<>();
            posList.add(value[0]);
            posList.add(value[1]);
            ans.add(posList);
        }
        return ans;
    }

    private int sgn(int x) {
        return Integer.compare(x, 0);
    }
}
