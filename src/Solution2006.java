import java.util.HashMap;
import java.util.Map;

public class Solution2006 {
    public int countKDifference(int[] nums, int k) {
        int res = 0, n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            res += cnt.getOrDefault(num - k, 0) + cnt.getOrDefault(num + k, 0);
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}
