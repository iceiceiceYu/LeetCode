public class Solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                if (A[i][left] == A[i][right]) {
                    A[i][left] ^= 1;
                    A[i][right] ^= 1;
                }
                left++;
                right--;
            }
            if (left == right) {
                A[i][left] ^= 1;
            }
        }
        return A;
    }
}
