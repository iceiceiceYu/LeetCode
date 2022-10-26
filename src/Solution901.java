import java.util.ArrayDeque;
import java.util.Deque;

public class Solution901 {
    class StockSpanner {
        Deque<int[]> stack;
        int idx;

        public StockSpanner() {
            stack = new ArrayDeque<>();
            stack.push(new int[]{-1, Integer.MAX_VALUE});
            idx = -1;
        }

        public int next(int price) {
            idx++;
            while (price >= stack.peek()[1]) {
                stack.pop();
            }
            int ret = idx - stack.peek()[0];
            stack.push(new int[]{idx, price});
            return ret;
        }
    }
}
