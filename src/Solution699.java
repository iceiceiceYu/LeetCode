import java.util.*;

public class Solution699 {
    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> ret = new ArrayList<>();
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        heightMap.put(0, 0);
        for (int i = 0; i < n; i++) {
            int size = positions[i][1];
            int left = positions[i][0], right = positions[i][0] + positions[i][1] - 1;
            Integer lp = heightMap.higherKey(left), rp = heightMap.higherKey(right);
            Integer prevRightKey = rp != null ? heightMap.lowerKey(rp) : heightMap.lastKey();
            int rHeight = prevRightKey != null ? heightMap.get(prevRightKey) : 0;

            int height = 0;
            Integer prevLeftKey = lp != null ? heightMap.lowerKey(lp) : heightMap.lastKey();
            Map<Integer, Integer> tail = prevLeftKey != null ? heightMap.tailMap(prevLeftKey) : heightMap;
            for (Map.Entry<Integer, Integer> entry : tail.entrySet()) {
                if (Objects.equals(entry.getKey(), rp)) {
                    break;
                }
                height = Math.max(height, entry.getValue() + size);
            }

            Set<Integer> keySet = new TreeSet<>(tail.keySet());
            for (Integer tmp : keySet) {
                if (lp == null || tmp < lp) {
                    continue;
                }
                if (rp != null && tmp >= rp) {
                    break;
                }
                heightMap.remove(tmp);
            }

            heightMap.put(left, height);
            if (rp == null || rp != right + 1) {
                heightMap.put(right + 1, rHeight);
            }
            ret.add(i > 0 ? Math.max(ret.get(i - 1), height) : height);
        }
        return ret;
    }
}
