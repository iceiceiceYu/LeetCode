import java.util.ArrayList;
import java.util.List;

public class Solution1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int prev = 0;
        for (int number : target) {
            for (int i = 0; i < number - prev - 1; i++) {
                res.add("Push");
                res.add("Pop");
            }
            res.add("Push");
            prev = number;
        }
        return res;
    }
}
