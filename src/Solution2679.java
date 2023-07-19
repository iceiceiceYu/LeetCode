import java.util.Arrays;

public class Solution2679 {
    public int matrixSum(int[][] nums) {
        int res = 0;
        int m = nums.length;
        int n = nums[0].length;
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        for (int j = 0; j < n; j++) {
            int maxVal = 0;
            for (int[] num : nums) {
                maxVal = Math.max(maxVal, num[j]);
            }
            res += maxVal;
        }
        return res;
    }
}
