import java.util.ArrayList;
import java.util.List;

public class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 1; i <= n; i++) {
            int m = ans.size();
            for (int j = m - 1; j >= 0; j--) {
                ans.add(ans.get(j) | (1 << (i - 1)));
            }
        }
        return ans;
    }
}
