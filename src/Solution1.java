import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int firstNum = 0;
        int secondNum = 0;
        Loop:
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    firstNum = i;
                    secondNum = j;
                    break Loop;
                }
            }
        }
        return new int[]{firstNum, secondNum};
    }
}
