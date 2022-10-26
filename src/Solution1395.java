import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1395 {
    int maxN;
    int[] c;
    List<Integer> disc;
    int[] iLess;
    int[] iMore;
    int[] kLess;
    int[] kMore;

    public int numTeams(int[] rating) {
        int n = rating.length;
        maxN = n + 2;
        c = new int[maxN];
        disc = new ArrayList<>();
        for (int i : rating) {
            disc.add(i);
        }
        disc.add(-1);
        Collections.sort(disc);
        iLess = new int[n];
        iMore = new int[n];
        kLess = new int[n];
        kMore = new int[n];

        for (int i = 0; i < n; ++i) {
            int id = getId(rating[i]);
            iLess[i] = get(id);
            iMore[i] = get(n + 1) - get(id);
            add(id, 1);
        }

        c = new int[maxN];
        for (int i = n - 1; i >= 0; --i) {
            int id = getId(rating[i]);
            kLess[i] = get(id);
            kMore[i] = get(n + 1) - get(id);
            add(id, 1);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += iLess[i] * kMore[i] + iMore[i] * kLess[i];
        }

        return ans;
    }

    private int getId(int target) {
        int low = 0, high = disc.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (disc.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int get(int p) {
        int r = 0;
        while (p > 0) {
            r += c[p];
            p -= lowBit(p);
        }
        return r;
    }

    private void add(int p, int v) {
        while (p < maxN) {
            c[p] += v;
            p += lowBit(p);
        }
    }

    private int lowBit(int x) {
        return x & (-x);
    }
}
