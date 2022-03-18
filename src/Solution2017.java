public class Solution2017 {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = -1, preMin = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > preMin) {
                ans = Math.max(ans, nums[i] - preMin);
            } else {
                preMin = nums[i];
            }
        }
        return ans;
    }
}
