public class Solution665 {
    //    public boolean checkPossibility(int[] nums) {
//        int n = nums.length;
//        for (int i = 0; i < n - 1; ++i) {
//            int x = nums[i], y = nums[i + 1];
//            if (x > y) {
//                nums[i] = y;
//                if (isSorted(nums)) {
//                    return true;
//                }
//                nums[i] = x; // 复原
//                nums[i + 1] = x;
//                return isSorted(nums);
//            }
//        }
//        return true;
//    }
//
//    public boolean isSorted(int[] nums) {
//        int n = nums.length;
//        for (int i = 1; i < n; ++i) {
//            if (nums[i - 1] > nums[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean checkPossibility(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}
