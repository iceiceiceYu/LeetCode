public class Solution495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int expired = 0;
        for (int time : timeSeries) {
            if (time >= expired) {
                ans += duration;
            } else {
                ans += time + duration - expired;
            }
            expired = time + duration;
        }
        return ans;
    }
}
