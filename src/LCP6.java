public class LCP6 {
    public int minCount(int[] coins) {
        int total = 0;
        for (int coin : coins) {
            if (coin % 2 == 0) {
                total += coin / 2;
            } else {
                total += coin / 2 + 1;
            }
        }
        return total;
    }
}
