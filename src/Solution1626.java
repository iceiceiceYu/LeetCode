import java.util.Arrays;

public class Solution1626 {
    int maxAge;
    int[] t;
    int[][] people;

    public int bestTeamScore(int[] scores, int[] ages) {
        maxAge = Arrays.stream(ages).max().getAsInt();
        t = new int[maxAge + 1];
        int res = 0;
        int n = scores.length;
        people = new int[n][2];
        for (int i = 0; i < n; ++i) {
            people[i] = new int[]{scores[i], ages[i]};
        }
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        for (int i = 0; i < n; ++i) {
            int score = people[i][0], age = people[i][1], cur = score + query(age);
            update(age, cur);
            res = Math.max(res, cur);
        }
        return res;
    }

    public int lowbit(int x) {
        return x & (-x);
    }

    public void update(int i, int val) {
        for (; i <= maxAge; i += lowbit(i)) {
            t[i] = Math.max(t[i], val);
        }
    }

    public int query(int i) {
        int ret = 0;
        for (; i > 0; i -= lowbit(i)) {
            ret = Math.max(ret, t[i]);
        }
        return ret;
    }
}
