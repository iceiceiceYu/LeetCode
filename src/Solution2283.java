import java.util.HashMap;
import java.util.Map;

public class Solution2283 {
    public boolean digitCount(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            map.put(digit, map.getOrDefault(digit, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int v = num.charAt(i) - '0';
            if (map.getOrDefault(i, 0) != v) {
                return false;
            }
        }
        return true;
    }
}
