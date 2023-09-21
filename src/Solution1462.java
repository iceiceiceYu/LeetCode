import java.util.ArrayList;
import java.util.List;

public class Solution1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] g = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<>();
        }
        boolean[] vi = new boolean[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            g[p[0]].add(p[1]);
        }
        for (int i = 0; i < numCourses; ++i) {
            dfs(g, isPre, vi, i);
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(isPre[query[0]][query[1]]);
        }
        return res;
    }

    private void dfs(List<Integer>[] g, boolean[][] isPre, boolean[] vi, int cur) {
        if (vi[cur]) {
            return;
        }
        vi[cur] = true;
        for (int ne : g[cur]) {
            dfs(g, isPre, vi, ne);
            isPre[cur][ne] = true;
            for (int i = 0; i < isPre.length; ++i) {
                isPre[cur][i] = isPre[cur][i] | isPre[ne][i];
            }
        }
    }
}
