public class Solution995 {
    public int minKBitFlips(int[] A, int K) {
//        int n = A.length;
//        int[] diff = new int[n + 1];
//        int ans = 0, revCnt = 0;
//        for (int i = 0; i < n; ++i) {
//            revCnt ^= diff[i];
//            if (A[i] == revCnt) { // A[i] ^ revCnt == 0
//                if (i + K > n) {
//                    return -1;
//                }
//                ++ans;
//                revCnt ^= 1;
//                diff[i + K] ^= 1;
//            }
//        }
//        return ans;
        int n = A.length;
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= K && A[i - K] > 1) {
                revCnt ^= 1;
                A[i - K] -= 2; // 复原数组元素，若允许修改数组 A，则可以省略
            }
            if (A[i] == revCnt) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                A[i] += 2;
            }
        }
        return ans;
    }
}
