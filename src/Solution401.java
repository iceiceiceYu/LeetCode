import java.util.ArrayList;
import java.util.List;

public class Solution401 {
//    public List<String> readBinaryWatch(int turnedOn) {
//        List<String> ans = new ArrayList<>();
//        for (int i = 0; i < 1024; ++i) {
//            int h = i >> 6, m = i & 63; // 用位运算取出高 4 位和低 6 位
//            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
//                ans.add(h + ":" + (m < 10 ? "0" : "") + m);
//            }
//        }
//        return ans;
//    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }
}
