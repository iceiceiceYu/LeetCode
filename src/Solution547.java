import java.util.LinkedList;
import java.util.Queue;

public class Solution547 {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{new int[]{1, 1, 0}, new int[]{1, 1, 0}, new int[]{1, 1, 0}}));
        System.out.println(findCircleNum(new int[][]{new int[]{1, 0, 0}, new int[]{0, 1, 0}, new int[]{0, 0, 1}}));
    }

    public static int findCircleNum(int[][] isConnected) {
        // bfs
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < provinces; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                circles++;
            }
        }
        return circles;

        // dfs
//        int provinces = isConnected.length;
//        boolean[] visited = new boolean[provinces];
//        int circles = 0;
//        for (int i = 0; i < provinces; i++) {
//            if (!visited[i]) {
//                dfs(isConnected, visited, provinces, i);
//                circles++;
//            }
//        }
//        return circles;
    }

    public static void dfs(int[][] isConnected, boolean[] visited, int provinces, int i) {
        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, provinces, j);
            }
        }
    }

//    public static int findCircleNum(int[][] isConnected) {
//        int provinces = isConnected.length;
//        int[] parent = new int[provinces];
//        for (int i = 0; i < provinces; i++) {
//            parent[i] = i;
//        }
//        for (int i = 0; i < provinces; i++) {
//            for (int j = i + 1; j < provinces; j++) {
//                if (isConnected[i][j] == 1) {
//                    union(parent, i, j);
//                }
//            }
//        }
//        int circles = 0;
//        for (int i = 0; i < provinces; i++) {
//            if (parent[i] == i) {
//                circles++;
//            }
//        }
//        return circles;
//    }
//
//    public static void union(int[] parent, int index1, int index2) {
//        parent[find(parent, index1)] = find(parent, index2);
//    }
//
//    public static int find(int[] parent, int index) {
//        if (parent[index] != index) {
//            parent[index] = find(parent, parent[index]);
//        }
//        return parent[index];
//    }
}
