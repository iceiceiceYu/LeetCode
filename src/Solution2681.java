import java.util.Arrays;

public class Solution2681 {
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int dp = 0, preSum = 0;
        int res = 0, mod = 1000000007;
        for (int num : nums) {
            dp = (num + preSum) % mod;
            preSum = (preSum + dp) % mod;
            res = (int) ((res + (long) num * num % mod * dp) % mod);
            if (res < 0) {
                res += mod;
            }
        }
        return res;
    }
}
