import java.util.Arrays;

public class Solution1030 {
    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {1, -1, -1, 1};

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(allCellsDistOrder(1, 2, 0, 0)));
        System.out.println(Arrays.deepToString(allCellsDistOrder(2, 2, 0, 1)));
        System.out.println(Arrays.deepToString(allCellsDistOrder(2, 3, 1, 2)));
    }

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        int[][] answer = new int[R * C][];
        int row = r0, col = c0;
        int index = 0;
        answer[index++] = new int[]{row, col};
        for (int dist = 1; dist <= maxDist; dist++) {
            row--;
            for (int i = 0; i < 4; i++) {
                while ((i % 2 == 0 && row != r0) || (i % 2 != 0 && col != c0)) {
                    if (row >= 0 && row < R && col >= 0 && col < C) {
                        answer[index++] = new int[]{row, col};
                    }
                    row += dr[i];
                    col += dc[i];
                }
            }
        }
        return answer;
    }
}
