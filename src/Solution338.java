public class Solution338 {
//    public int[] countBits(int num) {
//        int[] bits = new int[num + 1];
//        for (int i = 0; i <= num; i++) {
//            bits[i] = countOnes(i);
//        }
//        return bits;
//    }
//
//    public int countOnes(int x) {
//        int ones = 0;
//        while (x > 0) {
//            x &= (x - 1);
//            ones++;
//        }
//        return ones;
//    }

//    public int[] countBits(int num) {
//        int[] bits = new int[num + 1];
//        int highBit = 0;
//        for (int i = 1; i <= num; i++) {
//            if ((i & (i - 1)) == 0) {
//                highBit = i;
//            }
//            bits[i] = bits[i - highBit] + 1;
//        }
//        return bits;
//    }

//    public int[] countBits(int num) {
//        int[] bits = new int[num + 1];
//        for (int i = 1; i <= num; i++) {
//            bits[i] = bits[i >> 1] + (i & 1);
//        }
//        return bits;
//    }

    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }
}
