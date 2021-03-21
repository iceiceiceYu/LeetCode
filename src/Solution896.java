public class Solution896 {
    public boolean isMonotonic(int[] A) {
        return isSorted(A, true) || isSorted(A, false);
    }

    public boolean isSorted(int[] A, boolean increasing) {
        int n = A.length;
        if (increasing) {
            for (int i = 0; i < n - 1; ++i) {
                if (A[i] > A[i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < n - 1; ++i) {
                if (A[i] < A[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
//    public boolean isMonotonic(int[] A) {
//        boolean inc = true, dec = true;
//        int n = A.length;
//        for (int i = 0; i < n - 1; ++i) {
//            if (A[i] > A[i + 1]) {
//                inc = false;
//            }
//            if (A[i] < A[i + 1]) {
//                dec = false;
//            }
//        }
//        return inc || dec;
//    }
}
