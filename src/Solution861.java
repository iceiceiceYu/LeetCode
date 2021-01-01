public class Solution861 {
    public static void main(String[] args) {
        System.out.println(matrixScore(new int[][]{
                new int[]{0, 0, 1, 1},
                new int[]{1, 0, 1, 0},
                new int[]{1, 1, 0, 0}}));
    }

    public static int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int answer = m * (1 << (n - 1));

        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int[] ints : A) {
                if (ints[0] == 1) {
                    nOnes += ints[j];
                } else {
                    nOnes += (1 - ints[j]);
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            answer += k * (1 << (n - j - 1));
        }
        return answer;
    }
}
