import java.util.*;

public class Solution710 {
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(n, blacklist);
     * int param_1 = obj.pick();
     */
    static class Solution {
        Map<Integer, Integer> b2w;
        Random random;
        int bound;

        public Solution(int n, int[] blacklist) {
            b2w = new HashMap<>();
            random = new Random();
            int m = blacklist.length;
            bound = n - m;
            Set<Integer> black = new HashSet<>();
            for (int b : blacklist) {
                if (b >= bound) {
                    black.add(b);
                }
            }

            int w = bound;
            for (int b : blacklist) {
                if (b < bound) {
                    while (black.contains(w)) {
                        ++w;
                    }
                    b2w.put(b, w);
                    ++w;
                }
            }
        }

        public int pick() {
            int x = random.nextInt(bound);
            return b2w.getOrDefault(x, x);
        }

    }
}
