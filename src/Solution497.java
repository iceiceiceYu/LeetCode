import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution497 {
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(rects);
     * int[] param_1 = obj.pick();
     */

    class Solution {
        Random rand;
        List<Integer> arr;
        int[][] rects;

        public Solution(int[][] rects) {
            rand = new Random();
            arr = new ArrayList<>();
            arr.add(0);
            this.rects = rects;
            for (int[] rect : rects) {
                int a = rect[0], b = rect[1], x = rect[2], y = rect[3];
                arr.add(arr.get(arr.size() - 1) + (x - a + 1) * (y - b + 1));
            }
        }

        public int[] pick() {
            int k = rand.nextInt(arr.get(arr.size() - 1));
            int rectIndex = binarySearch(arr, k + 1) - 1;
            k -= arr.get(rectIndex);
            int[] rect = rects[rectIndex];
            int a = rect[0], b = rect[1], y = rect[3];
            int col = y - b + 1;
            int da = k / col;
            int db = k - col * da;
            return new int[]{a + da, b + db};
        }

        private int binarySearch(List<Integer> arr, int target) {
            int low = 0, high = arr.size() - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int num = arr.get(mid);
                if (num == target) {
                    return mid;
                } else if (num > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }
}
