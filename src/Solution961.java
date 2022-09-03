import java.util.Random;

public class Solution961 {
    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

    public static int repeatedNTimes(int[] nums) {
        int n = nums.length;
        Random random = new Random();

        while (true) {
            int x = random.nextInt(n), y = random.nextInt(n);
            if (x != y && nums[x] == nums[y]) {
                return nums[x];
            }
        }
    }
}
