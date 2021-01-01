import java.util.Arrays;

public class Solution283 {
    public static void main(String[] args) {
        int[] ints = new int[]{0, 1, 0, 3, 12};
        moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
