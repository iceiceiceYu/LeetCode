import java.util.ArrayDeque;
import java.util.Queue;

public class OfferII41 {
    static class MovingAverage {
        Queue<Integer> queue;
        int size;
        double sum;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            queue = new ArrayDeque<>();
            this.size = size;
            sum = 0;
        }

        public double next(int val) {
            if (queue.size() == size) {
                sum -= queue.poll();
            }
            queue.offer(val);
            sum += val;
            return sum / queue.size();
        }
    }
}
