public class Solution427 {
    public Node construct(int[][] grid) {
        int n = grid.length;
        int[][] pre = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        return dfs(grid, pre, 0, 0, n, n);
    }

    private Node dfs(int[][] grid, int[][] pre, int r0, int c0, int r1, int c1) {
        int total = getSum(pre, r0, c0, r1, c1);
        if (total == 0) {
            return new Node(false, true);
        } else if (total == (r1 - r0) * (c1 - c0)) {
            return new Node(true, true);
        }

        Node ret = new Node(
                true,
                false,
                dfs(grid, pre, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2),
                dfs(grid, pre, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1),
                dfs(grid, pre, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2),
                dfs(grid, pre, (r0 + r1) / 2, (c0 + c1) / 2, r1, c1)
        );
        return ret;
    }

    private int getSum(int[][] pre, int r0, int c0, int r1, int c1) {
        return pre[r1][c1] - pre[r1][c0] - pre[r0][c1] + pre[r0][c0];
    }

    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
