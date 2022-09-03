import java.util.ArrayList;
import java.util.List;

public class Solution729 {
    static class MyCalendar {
        List<int[]> booked;

        public MyCalendar() {
            booked = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] arr : booked) {
                int l = arr[0], r = arr[1];
                if (l < end && start < r) {
                    return false;
                }
            }
            booked.add(new int[]{start, end});
            return true;
        }
    }
}
