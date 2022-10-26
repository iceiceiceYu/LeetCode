import java.util.ArrayList;
import java.util.List;

public class Solution886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; ++i) {
            g[i] = new ArrayList<>();
        }
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; ++i) {
            if (color[i] == 0 && !dfs(i, 1, color, g)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int curNode, int nowColor, int[] color, List<Integer>[] g) {
        color[curNode] = nowColor;
        for (int nextNode : g[curNode]) {
            if (color[nextNode] != 0 && color[nextNode] == color[curNode]) {
                return false;
            }
            if (color[nextNode] == 0 && !dfs(nextNode, 3 ^ nowColor, color, g)) {
                return false;
            }
        }
        return true;
    }
}
