import java.util.Arrays;

public class Solution1502 {
    public static void main(String[] args) {
        System.out.println(canMakeArithmeticProgression(new int[]{3, 5, 1}));
        System.out.println(canMakeArithmeticProgression(new int[]{1, 2, 4}));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (d != arr[i] - arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
