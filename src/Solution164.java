import java.util.Arrays;

public class Solution164 {
    public static void main(String[] args) {
        System.out.println(maximumGap(new int[]{3, 6, 9, 1}));
        System.out.println(maximumGap(new int[]{10}));
    }

    public static int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > max) {
                max = nums[i] - nums[i - 1];
            }
        }
        return max;
    }
}
