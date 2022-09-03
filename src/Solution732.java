import java.util.HashMap;
import java.util.Map;

public class Solution732 {
    /**
     * Your MyCalendarThree object will be instantiated and called as such:
     * MyCalendarThree obj = new MyCalendarThree();
     * int param_1 = obj.book(start,end);
     */

    class MyCalendarThree {
        private final Map<Integer, Integer> tree;
        private final Map<Integer, Integer> lazy;

        public MyCalendarThree() {
            tree = new HashMap<>();
            lazy = new HashMap<>();
        }

        public int book(int start, int end) {
            update(start, end - 1, 0, 1000000000, 1);
            return tree.getOrDefault(1, 0);
        }

        private void update(int start, int end, int l, int r, int idx) {
            if (r < start || end < l) {
                return;
            }
            if (start <= l && r <= end) {
                tree.put(idx, tree.getOrDefault(idx, 0) + 1);
                lazy.put(idx, lazy.getOrDefault(idx, 0) + 1);
            } else {
                int mid = (l + r) >> 1;
                update(start, end, l, mid, 2 * idx);
                update(start, end, mid + 1, r, 2 * idx + 1);
                tree.put(idx, lazy.getOrDefault(idx, 0) + Math.max(tree.getOrDefault(2 * idx, 0), tree.getOrDefault(2 * idx + 1, 0)));
            }
        }
    }
}
