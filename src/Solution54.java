import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> order = new ArrayList<Integer>();
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return order;
//        }
//        int rows = matrix.length, columns = matrix[0].length;
//        boolean[][] visited = new boolean[rows][columns];
//        int total = rows * columns;
//        int row = 0, column = 0;
//        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//        int directionIndex = 0;
//        for (int i = 0; i < total; i++) {
//            order.add(matrix[row][column]);
//            visited[row][column] = true;
//            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
//            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
//                directionIndex = (directionIndex + 1) % 4;
//            }
//            row += directions[directionIndex][0];
//            column += directions[directionIndex][1];
//        }
//        return order;
//    }
}
