import java.util.HashMap;
import java.util.Map;

public class Solution1742 {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int box = 0, x = i;
            while (x != 0) {
                box += x % 10;
                x /= 10;
            }
            count.put(box, count.getOrDefault(box, 0) + 1);
            res = Math.max(res, count.get(box));
        }
        return res;
    }
}
