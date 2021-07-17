import java.util.ArrayList;
import java.util.List;

public class Solution1239 {
    int ans = 0;

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<Integer>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch; // 将 ch 加入 mask 中
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }

        backtrack(masks, 0, 0);
        return ans;
    }

    private void backtrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        if ((mask & masks.get(pos)) == 0) { // mask 和 masks[pos] 无公共元素
            backtrack(masks, pos + 1, mask | masks.get(pos));
        }
        backtrack(masks, pos + 1, mask);
    }

//    public int maxLength(List<String> arr) {
//        int ans = 0;
//        List<Integer> masks = new ArrayList<>();
//        masks.add(0);
//        for (String s : arr) {
//            int mask = 0;
//            for (int i = 0; i < s.length(); ++i) {
//                int ch = s.charAt(i) - 'a';
//                if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
//                    mask = 0;
//                    break;
//                }
//                mask |= 1 << ch; // 将 ch 加入 mask 中
//            }
//            if (mask == 0) {
//                continue;
//            }
//            int n = masks.size();
//            for (int i = 0; i < n; ++i) {
//                int m = masks.get(i);
//                if ((m & mask) == 0) { // m 和 mask 无公共元素
//                    masks.add(m | mask);
//                    ans = Math.max(ans, Integer.bitCount(m | mask));
//                }
//            }
//        }
//        return ans;
//    }
}
