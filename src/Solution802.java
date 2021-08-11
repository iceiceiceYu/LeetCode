import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (safe(graph, color, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean safe(int[][] graph, int[] color, int x) {
        if (color[x] > 0) {
            return color[x] == 2;
        }
        color[x] = 1;
        for (int y : graph[x]) {
            if (!safe(graph, color, y)) {
                return false;
            }
        }
        color[x] = 2;
        return true;
    }

//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        int n = graph.length;
//        List<List<Integer>> rg = new ArrayList<>();
//        for (int i = 0; i < n; ++i) {
//            rg.add(new ArrayList<>());
//        }
//        int[] inDeg = new int[n];
//        for (int x = 0; x < n; ++x) {
//            for (int y : graph[x]) {
//                rg.get(y).add(x);
//            }
//            inDeg[x] = graph[x].length;
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < n; ++i) {
//            if (inDeg[i] == 0) {
//                queue.offer(i);
//            }
//        }
//        while (!queue.isEmpty()) {
//            int y = queue.poll();
//            for (int x : rg.get(y)) {
//                if (--inDeg[x] == 0) {
//                    queue.offer(x);
//                }
//            }
//        }
//
//        List<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < n; ++i) {
//            if (inDeg[i] == 0) {
//                ans.add(i);
//            }
//        }
//        return ans;
//    }
}
