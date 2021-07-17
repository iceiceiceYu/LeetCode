public class Solution1886 {
    boolean flag = true, flag90 = true, flag180 = true, flag270 = true;

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        if (n == 1) return mat[0][0] == target[0][0];
        if (n % 2 == 1 && mat[n / 2][n / 2] != target[n / 2][n / 2]) {
            return false;
        }
        for (int i = 0; i < n / 2; i++) {
            helper(mat, i, n - 1 - i, target);
        }

        return flag || flag90 || flag180 || flag270;
    }

    private void helper(int[][] mat, int b, int e, int[][] target) {
        for (int i = b; i <= e; i++) {
            if (mat[b][i] != target[i][e] || mat[i][e] != target[e][e - i + b] ||
                    mat[e][e - i + b] != target[e - i + b][b] || mat[e - i + b][b] != target[b][i]) {
                flag90 = false;
            }

            if (mat[b][i] != target[e][e - i + b] || mat[i][e] != target[e - i + b][b] ||
                    mat[e][e - i + b] != target[b][i] || mat[e - i + b][b] != target[i][e]) {
                flag180 = false;
            }

            if (mat[b][i] != target[e - i + b][b] || mat[i][e] != target[b][i] ||
                    mat[e][e - i + b] != target[i][e] || mat[e - i + b][b] != target[e][e - i + b]) {
                flag270 = false;
            }

            if (mat[b][i] != target[b][i] || mat[i][e] != target[i][e] ||
                    mat[e][e - i + b] != target[e][e - i + b] || mat[e - i + b][b] != target[e - i + b][b]) {
                flag = false;
            }
        }
    }
}
