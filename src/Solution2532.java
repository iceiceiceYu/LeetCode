import java.util.PriorityQueue;

public class Solution2532 {
    public int findCrossingTime(int n, int k, int[][] time) {
        // 定义等待中的工人优先级比较规则，时间总和越高，效率越低，优先级越低，越优先被取出
        PriorityQueue<Integer> waitLeft = new PriorityQueue<>((x, y) -> {
            int timeX = time[x][0] + time[x][2];
            int timeY = time[y][0] + time[y][2];
            return timeX != timeY ? timeY - timeX : y - x;
        });
        PriorityQueue<Integer> waitRight = new PriorityQueue<>((x, y) -> {
            int timeX = time[x][0] + time[x][2];
            int timeY = time[y][0] + time[y][2];
            return timeX != timeY ? timeY - timeX : y - x;
        });

        PriorityQueue<int[]> workLeft = new PriorityQueue<>((x, y) -> {
            if (x[0] != y[0]) {
                return x[0] - y[0];
            } else {
                return x[1] - y[1];
            }
        });
        PriorityQueue<int[]> workRight = new PriorityQueue<>((x, y) -> {
            if (x[0] != y[0]) {
                return x[0] - y[0];
            } else {
                return x[1] - y[1];
            }
        });

        int remain = n, curTime = 0;
        for (int i = 0; i < k; i++) {
            waitLeft.offer(i);
        }
        while (remain > 0 || !workRight.isEmpty() || !waitRight.isEmpty()) {
            // 1. 若 workLeft 或 workRight 中的工人完成工作，则将他们取出，并分别放置到 waitLeft 和 waitRight 中。
            while (!workLeft.isEmpty() && workLeft.peek()[0] <= curTime) {
                waitLeft.offer(workLeft.poll()[1]);
            }
            while (!workRight.isEmpty() && workRight.peek()[0] <= curTime) {
                waitRight.offer(workRight.poll()[1]);
            }

            if (!waitRight.isEmpty()) {
                // 2. 若右侧有工人在等待，则取出优先级最低的工人并过桥
                int id = waitRight.poll();
                curTime += time[id][2];
                workLeft.offer(new int[]{curTime + time[id][3], id});
            } else if (remain > 0 && !waitLeft.isEmpty()) {
                // 3. 若右侧还有箱子，并且左侧有工人在等待，则取出优先级最低的工人并过桥
                int id = waitLeft.poll();
                curTime += time[id][0];
                workRight.offer(new int[]{curTime + time[id][1], id});
                remain--;
            } else {
                // 4. 否则，没有人需要过桥，时间过渡到 workLeft 和 workRight 中的最早完成时间
                int nextTime = Integer.MAX_VALUE;
                if (!workLeft.isEmpty()) {
                    nextTime = Math.min(nextTime, workLeft.peek()[0]);
                }
                if (!workRight.isEmpty()) {
                    nextTime = Math.min(nextTime, workRight.peek()[0]);
                }
                if (nextTime != Integer.MAX_VALUE) {
                    curTime = Math.max(nextTime, curTime);
                }
            }
        }
        return curTime;
    }
}
