public class Solution135 {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 0, 2}));
        System.out.println(candy(new int[]{1, 2, 2}));
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
//        int n = ratings.length;
//        int ret = 1;
//        int inc = 1, dec = 0, pre = 1;
//        for (int i = 1; i < n; i++) {
//            if (ratings[i] >= ratings[i - 1]) {
//                dec = 0;
//                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
//                ret += pre;
//                inc = pre;
//            } else {
//                dec++;
//                if (dec == inc) {
//                    dec++;
//                }
//                ret += dec;
//                pre = 1;
//            }
//        }
//        return ret;
    }
}
