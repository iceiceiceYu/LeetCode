public class Solution2562 {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (i != j) {
                ans += Integer.parseInt(nums[i] + Integer.toString(nums[j]));
            } else {
                ans += nums[i];
            }
        }
        return ans;
    }
}
