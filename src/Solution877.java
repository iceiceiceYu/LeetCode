public class Solution877 {
    public boolean stoneGame(int[] piles) {
        return true;

//        int length = piles.length;
//        int[] dp = new int[length];
//        System.arraycopy(piles, 0, dp, 0, length);
//        for (int i = length - 2; i >= 0; i--) {
//            for (int j = i + 1; j < length; j++) {
//                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
//            }
//        }
//        return dp[length - 1] > 0;
    }
}
