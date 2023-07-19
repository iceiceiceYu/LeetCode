import java.util.ArrayList;
import java.util.List;

public class Solution1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = 0, two = 0;
        for (int j : colsum) {
            if (j == 2) {
                two++;
            }
            sum += j;
        }
        if (sum != upper + lower || Math.min(upper, lower) < two) {
            return new ArrayList<>();
        }
        upper -= two;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            res.add(new ArrayList<>());
        }
        for (int j : colsum) {
            if (j == 2) {
                res.get(0).add(1);
                res.get(1).add(1);
            } else if (j == 1) {
                if (upper > 0) {
                    res.get(0).add(1);
                    res.get(1).add(0);
                    upper--;
                } else {
                    res.get(0).add(0);
                    res.get(1).add(1);
                }
            } else {
                res.get(0).add(0);
                res.get(1).add(0);
            }
        }
        return res;
    }
}
