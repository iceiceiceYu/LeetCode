import java.util.PriorityQueue;

public class Solution703 {
    static class KthLargest {
        private final int kth;
        private final PriorityQueue<Integer> queue;

        public KthLargest(int k, int[] nums) {
            kth = k;
            queue = new PriorityQueue<>();
            for (int num : nums) add(num);
        }

        public int add(int val) {
            queue.add(val);
            if (queue.size() > kth) {
                queue.poll();
            }
            return queue.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
