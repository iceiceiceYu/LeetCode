public class Solution1739 {
    public int minimumBoxes(int n) {
        int i = (int) Math.pow(6.0 * n, 1.0 / 3);
        if (g(i) < n) {
            i++;
        }
        n -= g(i - 1);
        int j = (int) Math.ceil((Math.sqrt((long) 8 * n + 1) - 1) / 2);
        return (i - 1) * i / 2 + j;
    }

    private long g(int x) {
        return (long) x * (x + 1) * (x + 2) / 6;
    }
}
