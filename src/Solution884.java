import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        insert(s1, map);
        insert(s2, map);

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans.add(entry.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }

    private void insert(String s, Map<String, Integer> map) {
        String[] arr = s.split(" ");
        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
    }
}
