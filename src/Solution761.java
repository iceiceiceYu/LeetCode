import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution761 {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) {
            return s;
        }
        int cnt = 0, left = 0;
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                ++cnt;
            } else {
                --cnt;
                if (cnt == 0) {
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }

        subs.sort(Comparator.reverseOrder());
        StringBuilder ans = new StringBuilder();
        for (String sub : subs) {
            ans.append(sub);
        }
        return ans.toString();
    }
}
