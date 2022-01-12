public class Solution414 {
    public int thirdMax(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;

//         Integer a = null, b = null, c = null;
//         for (int num : nums) {
//             if (a == null || num > a) {
//                 c = b;
//                 b = a;
//                 a = num;
//             } else if (a > num && (b == null || num > b)) {
//                 c = b;
//                 b = num;
//             } else if (b != null && b > num && (c == null || num > c)) {
//                 c = num;
//             }
//         }
//         return c == null ? a : c;
    }
}
