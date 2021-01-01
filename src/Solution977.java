import java.util.Arrays;

public class Solution977 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    public static int[] sortedSquares(int[] A) {
        int length = A.length;
//        for (int i = 0; i < length; i++) {
//            A[i] = A[i] * A[i];
//        }
//        Arrays.sort(A);
//        return A;
        int[] answer = new int[length];
        for (int i = 0, j = length - 1, pos = length - 1; i <= j; pos--) {
            if (A[i] * A[i] > A[j] * A[j]) {
                answer[pos] = A[i] * A[i];
                i++;
            } else {
                answer[pos] = A[j] * A[j];
                j--;
            }
        }
        return answer;
    }
}
