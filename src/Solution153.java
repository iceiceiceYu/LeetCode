public class Solution153 {
    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];

//        int low = 0;
//        int high = nums.length - 1;
//        while (low < high) {
//            int pivot = low + (high - low) / 2;
//            if (nums[pivot] < nums[high]) {
//                high = pivot;
//            } else {
//                low = pivot + 1;
//            }
//        }
//        return nums[low];
    }
}
