import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution454 {
    public static void main(String[] args) {
        System.out.println(fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2}));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        int count = 0;
        for (int i : C) {
            for (int j : D) {
                if (map.containsKey(-i - j)) {
                    count += map.get(-i - j);
                }
            }
        }
        return count;
    }
}
