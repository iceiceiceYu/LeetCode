import java.util.*;

public class Solution773 {
    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                sb.append(board[i][j]);
            }
        }
        String initial = sb.toString();
        if ("123450".equals(initial)) {
            return 0;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(initial);
        Set<String> seen = new HashSet<>();
        seen.add(initial);

        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String status = queue.poll();
                for (String nextStatus : get(status)) {
                    if (!seen.contains(nextStatus)) {
                        if ("123450".equals(nextStatus)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }

        return -1;
    }

    // 枚举 status 通过一次交换操作得到的状态
    public List<String> get(String status) {
        List<String> ret = new ArrayList<>();
        char[] array = status.toCharArray();
        int x = status.indexOf('0');
        for (int y : neighbors[x]) {
            swap(array, x, y);
            ret.add(new String(array));
            swap(array, x, y);
        }
        return ret;
    }

    public void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

//     int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

//     public int slidingPuzzle(int[][] board) {
//         StringBuffer sb = new StringBuffer();
//         for (int i = 0; i < 2; ++i) {
//             for (int j = 0; j < 3; ++j) {
//                 sb.append(board[i][j]);
//             }
//         }
//         String initial = sb.toString();
//         if ("123450".equals(initial)) {
//             return 0;
//         }

//         PriorityQueue<AStar> pq = new PriorityQueue<AStar>((a, b) -> a.f - b.f);
//         pq.offer(new AStar(initial, 0));
//         Set<String> seen = new HashSet<String>();
//         seen.add(initial);

//         while (!pq.isEmpty()) {
//             AStar node = pq.poll();
//             for (String nextStatus : get(node.status)) {
//                 if (!seen.contains(nextStatus)) {
//                     if ("123450".equals(nextStatus)) {
//                         return node.g + 1;
//                     }
//                     pq.offer(new AStar(nextStatus, node.g + 1));
//                     seen.add(nextStatus);
//                 }
//             }
//         }

//         return -1;
//     }

//     // 枚举 status 通过一次交换操作得到的状态
//     public List<String> get(String status) {
//         List<String> ret = new ArrayList<String>();
//         char[] array = status.toCharArray();
//         int x = status.indexOf('0');
//         for (int y : neighbors[x]) {
//             swap(array, x, y);
//             ret.add(new String(array));
//             swap(array, x, y);
//         }
//         return ret;
//     }

//     public void swap(char[] array, int x, int y) {
//         char temp = array[x];
//         array[x] = array[y];
//         array[y] = temp;
//     }
// }

// class AStar {
//     // 曼哈顿距离
//     public static int[][] dist = {
//         {0, 1, 2, 1, 2, 3},
//         {1, 0, 1, 2, 1, 2},
//         {2, 1, 0, 3, 2, 1},
//         {1, 2, 3, 0, 1, 2},
//         {2, 1, 2, 1, 0, 1},
//         {3, 2, 1, 2, 1, 0}
//     };

//     public String status;
//     public int f, g, h;

//     public AStar(String status, int g) {
//         this.status = status;
//         this.g = g;
//         this.h = getH(status);
//         this.f = this.g + this.h;
//     }

//     // 计算启发函数
//     public static int getH(String status) {
//         int ret = 0;
//         for (int i = 0; i < 6; ++i) {
//             if (status.charAt(i) != '0') {
//                 ret += dist[i][status.charAt(i) - '1'];
//             }
//         }
//         return ret;
//     }
}
