import java.util.HashMap;
import java.util.Map;

public class Solution2287 {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> sCounts = new HashMap<>();
        Map<Character, Integer> targetCounts = new HashMap<>();
        int n = s.length(), m = target.length();
        for (int i = 0; i < m; i++) {
            char c = target.charAt(i);
            targetCounts.put(c, targetCounts.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (targetCounts.containsKey(c)) {
                sCounts.put(c, sCounts.getOrDefault(c, 0) + 1);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : targetCounts.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            int totalCount = sCounts.getOrDefault(c, 0);
            ans = Math.min(ans, totalCount / count);
            if (ans == 0) {
                return 0;
            }
        }
        return ans;
    }
}
