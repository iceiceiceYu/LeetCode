public class Solution1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(help(nums, firstLen, secondLen), help(nums, secondLen, firstLen));
    }

    public int help(int[] nums, int firstLen, int secondLen) {
        int sumL = 0;
        for (int i = 0; i < firstLen; ++i) {
            sumL += nums[i];
        }
        int maxSumL = sumL;
        int sumR = 0;
        for (int i = firstLen; i < firstLen + secondLen; ++i) {
            sumR += nums[i];
        }
        int res = maxSumL + sumR;
        for (int i = firstLen + secondLen, j = firstLen; i < nums.length; ++i, ++j) {
            sumL += nums[j] - nums[j - firstLen];
            maxSumL = Math.max(maxSumL, sumL);
            sumR += nums[i] - nums[i - secondLen];
            res = Math.max(res, maxSumL + sumR);
        }
        return res;
    }
}
