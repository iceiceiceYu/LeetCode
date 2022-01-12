import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution911 {
    /**
     * Your TopVotedCandidate object will be instantiated and called as such:
     * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
     * int param_1 = obj.q(t);
     */
    static class TopVotedCandidate {
        List<Integer> tops;
        Map<Integer, Integer> voteCounts;
        int[] times;

        public TopVotedCandidate(int[] persons, int[] times) {
            tops = new ArrayList<>();
            voteCounts = new HashMap<>();
            voteCounts.put(-1, -1);
            int top = -1;
            for (int p : persons) {
                voteCounts.put(p, voteCounts.getOrDefault(p, 0) + 1);
                if (voteCounts.get(p) >= voteCounts.get(top)) {
                    top = p;
                }
                tops.add(top);
            }
            this.times = times;
        }

        public int q(int t) {
            int l = 0, r = times.length - 1;
            while (l < r) {
                int m = l + (r - l + 1) / 2;
                if (times[m] <= t) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            return tops.get(l);
        }
    }
}
