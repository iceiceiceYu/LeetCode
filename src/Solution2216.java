import java.util.Deque;
import java.util.LinkedList;

public class Solution2216 {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        Deque<Integer> deque = new LinkedList<>();
        deque.push(nums[0]);
        for (int i = 1; i < n; i++) {
            if (deque.size() % 2 == 0) {
                deque.push(nums[i]);
            } else {
                int val = deque.peek();
                if (nums[i] == val) {
                    continue;
                }
                deque.push(nums[i]);
            }
        }
        if (deque.size() % 2 == 0) {
            return n - deque.size();
        }
        return n - deque.size() + 1;
    }
}
