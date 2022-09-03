import java.util.*;

public class Solution1606 {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                available.add(busy.poll()[1]);
            }
            if (available.isEmpty()) {
                continue;
            }
            Integer p = available.ceiling(i % k);
            if (p == null) {
                p = available.first();
            }
            requests[p]++;
            busy.offer(new int[]{arrival[i] + load[i], p});
            available.remove(p);
        }
        int maxRequest = Arrays.stream(requests).max().getAsInt();
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequest) {
                ret.add(i);
            }
        }
        return ret;
    }

//    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
//        PriorityQueue<Integer> available = new PriorityQueue<>(Comparator.comparingInt(a -> a));
//        for (int i = 0; i < k; i++) {
//            available.offer(i);
//        }
//        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
//        int[] requests = new int[k];
//        for (int i = 0; i < arrival.length; i++) {
//            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
//                int id = busy.peek()[1];
//                busy.poll();
//                available.offer(i + ((id - i) % k + k) % k); // 保证得到的是一个不小于 i 的且与 id 同余的数
//            }
//            if (available.isEmpty()) {
//                continue;
//            }
//            int server = available.poll() % k;
//            requests[server]++;
//            busy.offer(new int[]{arrival[i] + load[i], server});
//        }
//        int maxRequest = Arrays.stream(requests).max().getAsInt();
//        List<Integer> ret = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            if (requests[i] == maxRequest) {
//                ret.add(i);
//            }
//        }
//        return ret;
//    }
}
