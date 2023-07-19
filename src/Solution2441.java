import java.util.HashSet;
import java.util.Set;

public class Solution2441 {
    public int findMaxK(int[] nums) {
        int k = -1;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        for (int x : nums) {
            if (set.contains(-x)) {
                k = Math.max(k, x);
            }
        }
        return k;
    }
}
