public class Solution790 {
    static final int MOD = 1000000007;

    public int numTilings(int n) {
        int[][] mat = {
                {0, 0, 0, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0},
                {1, 1, 1, 1}
        };
        int[][] matn = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        while (n > 0) {
            if ((n & 1) != 0) {
                matn = mulMatrix(matn, mat);
            }
            mat = mulMatrix(mat, mat);
            n >>= 1;
        }
        return matn[3][3];
    }

    private int[][] mulMatrix(int[][] m1, int[][] m2) {
        int n1 = m1.length, n2 = m2.length, n3 = m2[0].length;
        int[][] res = new int[n1][n3];
        for (int i = 0; i < n1; i++) {
            for (int k = 0; k < n3; k++) {
                for (int j = 0; j < n2; j++) {
                    res[i][k] = (int) ((res[i][k] + (long) m1[i][j] * m2[j][k]) % MOD);
                }
            }
        }
        return res;
    }
}
