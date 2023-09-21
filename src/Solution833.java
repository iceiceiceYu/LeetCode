import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length(), m = indices.length;

        Map<Integer, List<Integer>> ops = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            ops.putIfAbsent(indices[i], new ArrayList<>());
            ops.get(indices[i]).add(i);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; ) {
            boolean succeed = false;
            if (ops.containsKey(i)) {
                for (int pt : ops.get(i)) {
                    if (s.substring(i, Math.min(i + sources[pt].length(), n)).equals(sources[pt])) {
                        succeed = true;
                        ans.append(targets[pt]);
                        i += sources[pt].length();
                        break;
                    }
                }
            }
            if (!succeed) {
                ans.append(s.charAt(i));
                ++i;
            }
        }
        return ans.toString();
    }
}
