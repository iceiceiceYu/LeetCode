public class Solution330 {
    public static void main(String[] args) {
        System.out.println(minPatches(new int[]{1, 3}, 6));
        System.out.println(minPatches(new int[]{1, 5, 10}, 20));
    }

    public static int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }
}
