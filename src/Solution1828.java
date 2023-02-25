public class Solution1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int cx = queries[i][0], cy = queries[i][1], cr = queries[i][2];
            for (int[] point : points) {
                int px = point[0], py = point[1];
                if ((cx - px) * (cx - px) + (cy - py) * (cy - py) <= cr * cr) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
