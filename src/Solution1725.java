public class Solution1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int res = 0, maxLen = 0;
        for (int[] rectangle : rectangles) {
            int l = rectangle[0], w = rectangle[1];
            int k = l <= w ? l : w;
//            int k = Math.min(l, w);
            if (k == maxLen) {
                res++;
            } else if (k > maxLen) {
                res = 1;
                maxLen = k;
            }
        }
        return res;
    }
}
