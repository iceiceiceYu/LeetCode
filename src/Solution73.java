public class Solution73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }

//    public void setZeroes(int[][] matrix) {
//        int m = matrix.length, n = matrix[0].length;
//        boolean flagCol0 = false, flagRow0 = false;
//        for (int i = 0; i < m; i++) {
//            if (matrix[i][0] == 0) {
//                flagCol0 = true;
//            }
//        }
//        for (int j = 0; j < n; j++) {
//            if (matrix[0][j] == 0) {
//                flagRow0 = true;
//            }
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    matrix[i][0] = matrix[0][j] = 0;
//                }
//            }
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        if (flagCol0) {
//            for (int i = 0; i < m; i++) {
//                matrix[i][0] = 0;
//            }
//        }
//        if (flagRow0) {
//            for (int j = 0; j < n; j++) {
//                matrix[0][j] = 0;
//            }
//        }
//    }

//    public void setZeroes(int[][] matrix) {
//        int m = matrix.length, n = matrix[0].length;
//        boolean[] row = new boolean[m];
//        boolean[] col = new boolean[n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    row[i] = col[j] = true;
//                }
//            }
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (row[i] || col[j]) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }
}
