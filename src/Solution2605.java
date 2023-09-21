import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        int s = same(nums1, nums2);
        if (s != -1) {
            return s;
        }

        int x = Arrays.stream(nums1).min().getAsInt();
        int y = Arrays.stream(nums2).min().getAsInt();
        return Math.min(x * 10 + y, y * 10 + x);
    }

    public int same(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums1) {
            s.add(num);
        }
        int x = 10;
        for (int num : nums2) {
            if (s.contains(num)) {
                x = Math.min(x, num);
            }
        }
        return x == 10 ? -1 : x;
    }
}
