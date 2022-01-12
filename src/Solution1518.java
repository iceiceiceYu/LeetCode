public class Solution1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }

//    public int numWaterBottles(int numBottles, int numExchange) {
//        int ans = 0, wine = numBottles;
//        while (numBottles >= numExchange) {
//            ans += wine;
//            wine = numBottles / numExchange;
//            numBottles -= (numExchange - 1) * wine;
//
//        }
//        ans += wine;
//        return ans;
//    }
}
