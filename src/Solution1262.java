import java.util.ArrayList;
import java.util.List;

public class Solution1262 {
    public int maxSumDivThree(int[] nums) {
        // 使用 v[0], v[1], v[2] 分别表示 a, b, c
        List<Integer>[] v = new List[3];
        for (int i = 0; i < 3; ++i) {
            v[i] = new ArrayList<>();
        }
        for (int num : nums) {
            v[num % 3].add(num);
        }
        v[1].sort((a, b) -> b - a);
        v[2].sort((a, b) -> b - a);

        int ans = 0;
        int lb = v[1].size(), lc = v[2].size();
        for (int cntb = lb - 2; cntb <= lb; ++cntb) {
            if (cntb >= 0) {
                for (int cntc = lc - 2; cntc <= lc; ++cntc) {
                    if (cntc >= 0 && (cntb - cntc) % 3 == 0) {
                        ans = Math.max(ans, getSum(v[1], 0, cntb) + getSum(v[2], 0, cntc));
                    }
                }
            }
        }
        return ans + getSum(v[0], 0, v[0].size());
    }

    public int getSum(List<Integer> list, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; ++i) {
            sum += list.get(i);
        }
        return sum;
    }
}
