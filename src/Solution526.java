public class Solution526 {
    public int countArrangement(int n) {
        int[] f = new int[1 << n];
        f[0] = 1;
        for (int mask = 1; mask < (1 << n); mask++) {
            int num = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0 && ((num % (i + 1)) == 0 || (i + 1) % num == 0)) {
                    f[mask] += f[mask ^ (1 << i)];
                }
            }
        }
        return f[(1 << n) - 1];
    }

//    List<Integer>[] match;
//    boolean[] vis;
//    int num;
//
//    public int countArrangement(int n) {
//        vis = new boolean[n + 1];
//        match = new List[n + 1];
//        for (int i = 0; i <= n; i++) {
//            match[i] = new ArrayList<>();
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (i % j == 0 || j % i == 0) {
//                    match[i].add(j);
//                }
//            }
//        }
//        backtrack(1, n);
//        return num;
//    }
//
//    private void backtrack(int index, int n) {
//        if (index == n + 1) {
//            num++;
//            return;
//        }
//        for (int x : match[index]) {
//            if (!vis[x]) {
//                vis[x] = true;
//                backtrack(index + 1, n);
//                vis[x] = false;
//            }
//        }
//    }
}
