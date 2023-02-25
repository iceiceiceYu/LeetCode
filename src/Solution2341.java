import java.util.HashMap;
import java.util.Map;

public class Solution2341 {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Boolean> cnt = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, !cnt.getOrDefault(num, false));
            if (!cnt.get(num)) {
                res++;
            }
        }
        return new int[]{res, nums.length - 2 * res};
    }
}
