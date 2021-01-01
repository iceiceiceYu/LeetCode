import java.util.Arrays;

public class Solution188 {
    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    public static int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell).max().getAsInt();
//        if (prices.length == 0) {
//            return 0;
//        }
//
//        int n = prices.length;
//        k = Math.min(k, n / 2);
//        int[][] buy = new int[n][k + 1];
//        int[][] sell = new int[n][k + 1];
//
//        buy[0][0] = -prices[0];
//        sell[0][0] = 0;
//        for (int i = 1; i <= k; ++i) {
//            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
//        }
//
//        for (int i = 1; i < n; ++i) {
//            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
//            for (int j = 1; j <= k; ++j) {
//                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
//                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
//            }
//        }
//
//        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }
}
