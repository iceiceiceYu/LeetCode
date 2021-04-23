public class Solution492 {
    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        if (sqrt * sqrt == area) {
            return new int[]{sqrt, sqrt};
        }
        for (int i = sqrt; i > 1; i--) {
            if (area % i == 0) {
                return new int[]{area / i, i};
            }
        }
        return new int[]{area, 1};
    }
}
