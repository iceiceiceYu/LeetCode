public class Solution1800 {
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        int l = 0;
        while (l < nums.length) {
            int curSum = nums[l++];
            while (l < nums.length && nums[l] > nums[l - 1]) {
                curSum += nums[l++];
            }
            res = Math.max(res, curSum);
        }
        return res;
    }
}
