import java.util.*;

public class Solution2352 {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> cnt = new HashMap<>();
        for (int[] row : grid) {
            List<Integer> arr = new ArrayList<>();
            for (int num : row) {
                arr.add(num);
            }
            cnt.put(arr, cnt.getOrDefault(arr, 0) + 1);
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> arr = new ArrayList<>();
            for (int[] ints : grid) {
                arr.add(ints[j]);
            }
            if (cnt.containsKey(arr)) {
                res += cnt.get(arr);
            }
        }
        return res;
    }
}
