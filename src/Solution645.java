public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length + 1];
        int dup = -1, missing = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0)
                missing = i;
            else if (arr[i] == 2)
                dup = i;
        }
        return new int[]{dup, missing};

//        int dup = -1, missing = 1;
//        for (int n : nums) {
//            if (nums[Math.abs(n) - 1] > 0) {
//                nums[Math.abs(n) - 1] *= -1;
//            } else {
//                dup = Math.abs(n);
//            }
//        }
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > 0) {
//                missing = i + 1;
//            }
//        }
//        return new int[]{dup, missing};
    }
}
