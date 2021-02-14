public class Solution803 {
    public static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int rows;
    private int cols;

    public int[] hitBricks(int[][] grid, int[][] hits) {
        this.rows = grid.length;
        this.cols = grid[0].length;

        int[][] copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (cols >= 0) {
                System.arraycopy(grid[i], 0, copy[i], 0, cols);
            }
        }

        for (int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }

        int size = rows * cols;
        UnionFind unionFind = new UnionFind(size + 1);

        for (int j = 0; j < cols; j++) {
            if (copy[0][j] == 1) {
                unionFind.union(j, size);
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (copy[i][j] == 1) {
                    if (copy[i - 1][j] == 1) {
                        unionFind.union(getIndex(i - 1, j), getIndex(i, j));
                    }
                    if (j > 0 && copy[i][j - 1] == 1) {
                        unionFind.union(getIndex(i, j - 1), getIndex(i, j));
                    }
                }
            }
        }

        int hitsLen = hits.length;
        int[] res = new int[hitsLen];
        for (int i = hitsLen - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];

            if (grid[x][y] == 0) {
                continue;
            }

            int origin = unionFind.getSize(size);

            if (x == 0) {
                unionFind.union(y, size);
            }

            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (inArea(newX, newY) && copy[newX][newY] == 1) {
                    unionFind.union(getIndex(x, y), getIndex(newX, newY));
                }
            }

            int current = unionFind.getSize(size);
            res[i] = Math.max(0, current - origin - 1);

            copy[x][y] = 1;
        }
        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private int getIndex(int x, int y) {
        return x * cols + y;
    }

    private static class UnionFind {
        private final int[] parent;

        private final int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            // 在合并的时候维护数组 size
            size[rootY] += size[rootX];
        }

        public int getSize(int x) {
            int root = find(x);
            return size[root];
        }
    }
}
