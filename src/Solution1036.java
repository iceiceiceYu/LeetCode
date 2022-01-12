import java.util.*;

public class Solution1036 {
    static final int BOUNDARY = 1000000;
    static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length < 2) {
            return true;
        }
        // 离散化
        TreeSet<Integer> rows = new TreeSet<>();
        TreeSet<Integer> columns = new TreeSet<>();
        for (int[] pos : blocked) {
            rows.add(pos[0]);
            columns.add(pos[1]);
        }
        rows.add(source[0]);
        rows.add(target[0]);
        columns.add(source[1]);
        columns.add(target[1]);

        Map<Integer, Integer> rMapping = new HashMap<Integer, Integer>();
        Map<Integer, Integer> cMapping = new HashMap<Integer, Integer>();

        int firstRow = rows.first();
        int rId = (firstRow == 0 ? 0 : 1);
        rMapping.put(firstRow, rId);
        int prevRow = firstRow;
        for (int row : rows) {
            if (row == firstRow) {
                continue;
            }
            rId += (row == prevRow + 1 ? 1 : 2);
            rMapping.put(row, rId);
            prevRow = row;
        }
        if (prevRow != BOUNDARY - 1) {
            ++rId;
        }

        int firstColumn = columns.first();
        int cId = (firstColumn == 0 ? 0 : 1);
        cMapping.put(firstColumn, cId);
        int prevColumn = firstColumn;
        for (int column : columns) {
            if (column == firstColumn) {
                continue;
            }
            cId += (column == prevColumn + 1 ? 1 : 2);
            cMapping.put(column, cId);
            prevColumn = column;
        }
        if (prevColumn != BOUNDARY - 1) {
            ++cId;
        }

        int[][] grid = new int[rId + 1][cId + 1];
        for (int[] pos : blocked) {
            int x = pos[0], y = pos[1];
            grid[rMapping.get(x)][cMapping.get(y)] = 1;
        }

        int sx = rMapping.get(source[0]), sy = cMapping.get(source[1]);
        int tx = rMapping.get(target[0]), ty = cMapping.get(target[1]);

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{sx, sy});
        grid[sx][sy] = 1;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0], y = arr[1];
            for (int d = 0; d < 4; ++d) {
                int nx = x + dirs[d][0], ny = y + dirs[d][1];
                if (nx >= 0 && nx <= rId && ny >= 0 && ny <= cId && grid[nx][ny] != 1) {
                    if (nx == tx && ny == ty) {
                        return true;
                    }
                    queue.offer(new int[]{nx, ny});
                    grid[nx][ny] = 1;
                }
            }
        }
        return false;
    }
}
