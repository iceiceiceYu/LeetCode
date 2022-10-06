public class CodingInterview17_19 {
    public int[] missingTwo(int[] nums) {
        int xorsum = 0;
        int n = nums.length + 2;
        for (int num : nums) {
            xorsum ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xorsum ^= i;
        }
        // 防止溢出
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & lsb) != 0) {
                type1 ^= i;
            } else {
                type2 ^= i;
            }
        }
        return new int[]{type1, type2};
    }
}
