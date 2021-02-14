import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution888 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1, 2}, new int[]{2, 3})));
        System.out.println(Arrays.toString(fairCandySwap(new int[]{2}, new int[]{1, 3})));
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<>();
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }
}
