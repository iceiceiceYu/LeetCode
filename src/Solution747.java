public class Solution747 {
    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(dominantIndex(new int[]{1, 2, 3, 4}));
    }

    public static int dominantIndex(int[] nums) {
//        int length = nums.length;
//        int maxIndex = 0;
//        for (int i = 1; i < length; i++) {
//            if (nums[i] > nums[maxIndex]) {
//                maxIndex = i;
//            }
//        }
//        for (int i = 0; i < length; i++) {
//            if (i != maxIndex && nums[maxIndex] < 2 * nums[i]) {
//                return -1;
//            }
//        }
//        return maxIndex;

        if (nums.length == 1) {
            return 0;
        }
        int max = 0, next = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                next = nums[max];
                max = i;
            } else if (nums[i] > next) {
                next = nums[i];
            }
        }
        return nums[max] < next * 2 ? -1 : max;
    }
}
