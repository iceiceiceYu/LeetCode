import java.util.Arrays;

public class Solution1480 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(runningSum(new int[]{1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(runningSum(new int[]{3, 1, 2, 10, 1})));
    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
