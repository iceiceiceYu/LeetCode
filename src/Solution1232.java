public class Solution1232 {
    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4},
                new int[]{4, 5},
                new int[]{5, 6},
                new int[]{6, 7}
        }));
        System.out.println(checkStraightLine(new int[][]{
                new int[]{1, 1},
                new int[]{2, 2},
                new int[]{3, 4},
                new int[]{4, 5},
                new int[]{5, 6},
                new int[]{7, 7}
        }));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (A * x + B * y != 0) {
                return false;
            }
        }
        return true;
    }
}
