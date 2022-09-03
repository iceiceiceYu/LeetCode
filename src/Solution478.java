import java.util.Random;

public class Solution478 {
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(radius, x_center, y_center);
     * double[] param_1 = obj.randPoint();
     */

    class Solution {
        Random random;
        double xc, yc, r;

        public Solution(double radius, double xCenter, double yCenter) {
            random = new Random();
            xc = xCenter;
            yc = yCenter;
            r = radius;
        }

        public double[] randPoint() {
            double u = random.nextDouble();
            double theta = random.nextDouble() * 2 * Math.PI;
            double r = Math.sqrt(u);
            return new double[]{xc + r * Math.cos(theta) * this.r, yc + r * Math.sin(theta) * this.r};
        }
    }
}
