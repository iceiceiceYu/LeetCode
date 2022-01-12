public class Solution223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int x1 = Math.abs(ax1 - ax2);
        int y1 = Math.abs(ay1 - ay2);
        int s1 = x1 * y1;

        int x2 = Math.abs(bx1 - bx2);
        int y2 = Math.abs(by1 - by2);
        int s2 = x2 * y2;

        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        int overlapArea = Math.max(overlapWidth, 0) * Math.max(overlapHeight, 0);

        return s1 + s2 - overlapArea;
    }
}
