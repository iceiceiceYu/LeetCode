public class Solution1732 {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int height = 0;
        for (int i : gain) {
            height += i;
            if (height > max) {
                max = height;
            }
        }
        return max;
    }
}
