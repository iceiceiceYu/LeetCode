import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution239 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{9, 11}, 2)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{4, -2}, 2)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // solution 1
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            }
            else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
        // solution 2
//        int n = nums.length;
//        Deque<Integer> deque = new LinkedList<>();
//        for (int i = 0; i < k; ++i) {
//            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
//                deque.pollLast();
//            }
//            deque.offerLast(i);
//        }
//
//        int[] ans = new int[n - k + 1];
//        ans[0] = nums[deque.peekFirst()];
//        for (int i = k; i < n; ++i) {
//            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
//                deque.pollLast();
//            }
//            deque.offerLast(i);
//            while (deque.peekFirst() <= i - k) {
//                deque.pollFirst();
//            }
//            ans[i - k + 1] = nums[deque.peekFirst()];
//        }
//        return ans;

        // solution 3
//        int n = nums.length;
//        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
//        for (int i = 0; i < k; ++i) {
//            pq.offer(new int[]{nums[i], i});
//        }
//        int[] ans = new int[n - k + 1];
//        ans[0] = pq.peek()[0];
//        for (int i = k; i < n; ++i) {
//            pq.offer(new int[]{nums[i], i});
//            while (pq.peek()[1] <= i - k) {
//                pq.poll();
//            }
//            ans[i - k + 1] = pq.peek()[0];
//        }
//        return ans;
    }
}
