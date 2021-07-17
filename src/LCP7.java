public class LCP7 {
    public int numWays(int n, int[][] relation, int k) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            int[] next = new int[n];
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                next[dst] += dp[src];
            }
            dp = next;
        }
        return dp[n - 1];
    }

//    int ways, n, k;
//    List<List<Integer>> edges;
//
//    public int numWays(int n, int[][] relation, int k) {
//        ways = 0;
//        this.n = n;
//        this.k = k;
//        edges = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            edges.add(new ArrayList<>());
//        }
//        for (int[] edge : relation) {
//            int src = edge[0], dst = edge[1];
//            edges.get(src).add(dst);
//        }
//        dfs(0, 0);
//        return ways;
//    }
//
//    private void dfs(int index, int steps) {
//        if (steps == k) {
//            if (index == n - 1) {
//                ways++;
//            }
//            return;
//        }
//        List<Integer> list = edges.get(index);
//        for (int nextIndex : list) {
//            dfs(nextIndex, steps + 1);
//        }
//    }
}
