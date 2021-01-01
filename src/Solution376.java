public class Solution376 {
    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int prevDiff = nums[1] - nums[0];
        int ret = prevDiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevDiff <= 0) || (diff < 0 && prevDiff >= 0)) {
                ret++;
                prevDiff = diff;
            }
        }
        return ret;
//        int n = nums.length;
//        if (n < 2) {
//            return n;
//        }
//        int up = 1, down = 1;
//        for (int i = 1; i < n; i++) {
//            if (nums[i] > nums[i - 1]) {
//                up = Math.max(up, down + 1);
//            } else if (nums[i] < nums[i - 1]) {
//                down = Math.max(up + 1, down);
//            }
//        }
//        return Math.max(up, down);
//        int n = nums.length;
//        if (n < 2) {
//            return n;
//        }
//        int[] up = new int[n];
//        int[] down = new int[n];
//        up[0] = down[0] = 1;
//        for (int i = 1; i < n; i++) {
//            if (nums[i] > nums[i - 1]) {
//                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
//                down[i] = down[i - 1];
//            } else if (nums[i] < nums[i - 1]) {
//                up[i] = up[i - 1];
//                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
//            } else {
//                up[i] = up[i - 1];
//                down[i] = down[i - 1];
//            }
//        }
//        return Math.max(up[n - 1], down[n - 1]);
    }
}
