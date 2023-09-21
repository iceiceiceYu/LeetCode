public class LCP50 {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int number = gem[operation[0]] / 2;
            gem[operation[0]] -= number;
            gem[operation[1]] += number;
        }
        int max = gem[0], min = gem[0];
        for (int i : gem) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return max - min;
    }
}
