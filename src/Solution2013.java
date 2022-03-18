import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution2013 {
    static class DetectSquares {
        Map<Integer, Map<Integer, Integer>> cnt;

        public DetectSquares() {
            cnt = new HashMap<>();
        }

        public void add(int[] point) {
            int x = point[0], y = point[1];
            cnt.putIfAbsent(y, new HashMap<Integer, Integer>());
            Map<Integer, Integer> yCnt = cnt.get(y);
            yCnt.put(x, yCnt.getOrDefault(x, 0) + 1);
        }

        public int count(int[] point) {
            int res = 0;
            int x = point[0], y = point[1];
            if (!cnt.containsKey(y)) {
                return 0;
            }
            Map<Integer, Integer> yCnt = cnt.get(y);
            Set<Map.Entry<Integer, Map<Integer, Integer>>> entries = cnt.entrySet();
            for (Map.Entry<Integer, Map<Integer, Integer>> entry : entries) {
                int col = entry.getKey();
                Map<Integer, Integer> colCnt = entry.getValue();
                if (col != y) {
                    // 根据对称性，这里可以不用取绝对值
                    int d = col - y;
                    res += colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x + d, 0) * colCnt.getOrDefault(x + d, 0);
                    res += colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x - d, 0) * colCnt.getOrDefault(x - d, 0);
                }
            }
            return res;
        }
    }
}
