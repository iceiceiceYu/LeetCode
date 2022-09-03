import java.util.Random;

public class Solution398 {
    class Solution {
        int[] nums;
        Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        public int pick(int target) {
            int ans = 0;
            for (int i = 0, cnt = 0; i < nums.length; ++i) {
                if (nums[i] == target) {
                    cnt++;
                    if (random.nextInt(cnt) == 0) {
                        ans = i;
                    }
                }
            }
            return ans;
        }
    }
}
