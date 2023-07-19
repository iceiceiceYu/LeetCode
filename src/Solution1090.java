import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Integer[] id = new Integer[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        Arrays.sort(id, (a, b) -> values[b] - values[a]);

        int ans = 0, choose = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n && choose < numWanted; ++i) {
            int label = labels[id[i]];
            if (cnt.getOrDefault(label, 0) == useLimit) {
                continue;
            }
            ++choose;
            ans += values[id[i]];
            cnt.put(label, cnt.getOrDefault(label, 0) + 1);
        }
        return ans;
    }
}
