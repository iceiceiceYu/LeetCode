import java.util.ArrayList;
import java.util.List;

public class Solution2682 {
    public int[] circularGameLosers(int n, int k) {
        boolean[] visit = new boolean[n];
        for (int i = k, j = 0; !visit[j]; i += k) {
            visit[j] = true;
            j = (j + i) % n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                list.add(i + 1);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
