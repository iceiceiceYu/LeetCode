import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution830 {
    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abbxxxxzzy"));
        System.out.println(largeGroupPositions("abc"));
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(largeGroupPositions("aba"));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
//        List<List<Integer>> ret = new ArrayList<>();
//        int n = s.length();
//        int num = 1;
//        for (int i = 0; i < n; i++) {
//            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
//                if (num >= 3) {
//                    ret.add(Arrays.asList(i - num + 1, i));
//                }
//                num = 1;
//            } else {
//                num++;
//            }
//        }
//        return ret;
        List<List<Integer>> res = new ArrayList<>();
        int left = 0;
        int length = s.length();
        while (left < length) {
            int count = 0;
            while (left + count < length && s.charAt(left) == s.charAt(left + count)) {
                count++;
            }
            if (count >= 3) {
                res.add(Arrays.asList(left, left + count - 1));
            }
            left = left + count;
        }
        return res;
    }
}
