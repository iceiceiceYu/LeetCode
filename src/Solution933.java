import java.util.ArrayDeque;
import java.util.Queue;

public class Solution933 {
    class RecentCounter {
        Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }
}
