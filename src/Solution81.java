public class Solution81 {
    public boolean search(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;

//        int n = nums.length;
//        if (n == 0) {
//            return false;
//        }
//        if (n == 1) {
//            return nums[0] == target;
//        }
//        int l = 0, r = n - 1;
//        while (l <= r) {
//            int mid = (l + r) / 2;
//            if (nums[mid] == target) {
//                return true;
//            }
//            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
//                ++l;
//                --r;
//            } else if (nums[l] <= nums[mid]) {
//                if (nums[l] <= target && target < nums[mid]) {
//                    r = mid - 1;
//                } else {
//                    l = mid + 1;
//                }
//            } else {
//                if (nums[mid] < target && target <= nums[n - 1]) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            }
//        }
//        return false;
    }
}
