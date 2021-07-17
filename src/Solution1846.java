import java.util.Arrays;

public class Solution1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int level = 1;
        for (int i = 1; i < arr.length; i++) {
            level = Math.min(level + 1, arr[i]);
        }
        return level;
    }
}
