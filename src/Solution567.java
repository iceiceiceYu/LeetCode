public class Solution567 {
    //    public boolean checkInclusion(String s1, String s2) {
//        int n = s1.length(), m = s2.length();
//        if (n > m) {
//            return false;
//        }
//        int[] cnt = new int[26];
//        for (int i = 0; i < n; ++i) {
//            --cnt[s1.charAt(i) - 'a'];
//            ++cnt[s2.charAt(i) - 'a'];
//        }
//        int diff = 0;
//        for (int c : cnt) {
//            if (c != 0) {
//                ++diff;
//            }
//        }
//        if (diff == 0) {
//            return true;
//        }
//        for (int i = n; i < m; ++i) {
//            int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
//            if (x == y) {
//                continue;
//            }
//            if (cnt[x] == 0) {
//                ++diff;
//            }
//            ++cnt[x];
//            if (cnt[x] == 0) {
//                --diff;
//            }
//            if (cnt[y] == 0) {
//                ++diff;
//            }
//            --cnt[y];
//            if (cnt[y] == 0) {
//                --diff;
//            }
//            if (diff == 0) {
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }
}
