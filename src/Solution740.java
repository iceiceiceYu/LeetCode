import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    private int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

//    public int deleteAndEarn(int[] nums) {
//        int n = nums.length;
//        int ans = 0;
//        Arrays.sort(nums);
//        List<Integer> sum = new ArrayList<>();
//        sum.add(nums[0]);
//        int size = 1;
//        for (int i = 1; i < n; ++i) {
//            int val = nums[i];
//            if (val == nums[i - 1]) {
//                sum.set(size - 1, sum.get(size - 1) + val);
//            } else if (val == nums[i - 1] + 1) {
//                sum.add(val);
//                ++size;
//            } else {
//                ans += rob(sum);
//                sum.clear();
//                sum.add(val);
//                size = 1;
//            }
//        }
//        ans += rob(sum);
//        return ans;
//    }
//
//    private int rob(List<Integer> nums) {
//        int size = nums.size();
//        if (size == 1) {
//            return nums.get(0);
//        }
//        int first = nums.get(0), second = Math.max(nums.get(0), nums.get(1));
//        for (int i = 2; i < size; i++) {
//            int temp = second;
//            second = Math.max(first + nums.get(i), second);
//            first = temp;
//        }
//        return second;
//    }
}
