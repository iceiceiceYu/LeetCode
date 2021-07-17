import java.util.Arrays;

public class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        int[] freq = new int[100001];
        for (int cost : costs) {
            freq[cost]++;
        }
        int count = 0;
        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                int curCount = Math.min(freq[i], coins / i);
                count += curCount;
                coins -= i * curCount;
            } else {
                break;
            }
        }
        return count;

//        Arrays.sort(costs);
//        int count = 0;
//        int n = costs.length;
//        for (int cost : costs) {
//            if (coins >= cost) {
//                coins -= cost;
//                count++;
//            } else {
//                break;
//            }
//        }
//        return count;
    }
}
