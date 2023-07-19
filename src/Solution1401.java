public class Solution1401 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        /* 圆心在矩形内部 */
        if (x1 <= xCenter && xCenter <= x2 && y1 <= yCenter && yCenter <= y2) {
            return true;
        }
        /* 圆心在矩形上部 */
        if (x1 <= xCenter && xCenter <= x2 && y2 <= yCenter && yCenter <= y2 + radius) {
            return true;
        }
        /* 圆心在矩形下部 */
        if (x1 <= xCenter && xCenter <= x2 && y1 - radius <= yCenter && yCenter <= y1) {
            return true;
        }
        /* 圆心在矩形左部 */
        if (x1 - radius <= xCenter && xCenter <= x1 && y1 <= yCenter && yCenter <= y2) {
            return true;
        }
        /* 圆心在矩形右部 */
        if (x2 <= xCenter && xCenter <= x2 + radius && y1 <= yCenter && yCenter <= y2) {
            return true;
        }
        /* 矩形左上角 */
        if (distance(xCenter, yCenter, x1, y2) <= radius * radius) {
            return true;
        }
        /* 矩形左下角 */
        if (distance(xCenter, yCenter, x1, y1) <= radius * radius) {
            return true;
        }
        /* 矩形右上角 */
        if (distance(xCenter, yCenter, x2, y2) <= radius * radius) {
            return true;
        }
        /* 矩形右下角 */
        if (distance(xCenter, yCenter, x1, y2) <= radius * radius) {
            return true;
        }
        /* 无交点 */
        return false;
    }

    public long distance(int ux, int uy, int vx, int vy) {
        return (long) Math.pow(ux - vx, 2) + (long) Math.pow(uy - vy, 2);
    }
}
