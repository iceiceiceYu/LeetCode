public class Solution2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[i * n + j];
            }
        }

//        for (int i = 0; i < original.length; i += n) {
//            System.arraycopy(original, i, ans[i / n], 0, n);
//        }
        return ans;
    }
}
