import java.util.ArrayList;
import java.util.List;

public class Solution1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int n = queries.length;
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            boolean flag = true;
            int p = 0;
            for (int j = 0; j < query.length(); j++) {
                char c = query.charAt(j);
                if (p < pattern.length() && pattern.charAt(p) == c) {
                    p++;
                } else if (Character.isUpperCase(c)) {
                    flag = false;
                    break;
                }
            }
            if (p < pattern.length()) {
                flag = false;
            }
            res.add(flag);
        }
        return res;
    }
}
