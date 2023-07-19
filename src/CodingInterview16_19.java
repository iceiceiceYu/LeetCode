import java.util.*;

public class CodingInterview16_19 {
    public int[] pondSizes(int[][] land) {
        int m = land.length, n = land[0].length;
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    resList.add(bfs(land, i, j));
                }
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    public int bfs(int[][] land, int x, int y) {
        int m = land.length, n = land[0].length;
        int res = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        land[x][y] = -1;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int currX = arr[0], currY = arr[1];
            res++;
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) {
                        continue;
                    }
                    if (currX + dx < 0 || currX + dx >= m || currY + dy < 0 || currY + dy >= n || land[currX + dx][currY + dy] != 0) {
                        continue;
                    }
                    land[currX + dx][currY + dy] = -1;
                    queue.offer(new int[]{currX + dx, currY + dy});
                }
            }
        }
        return res;
    }
}
