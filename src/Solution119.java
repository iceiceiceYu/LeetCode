import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
//        List<Integer> row = new ArrayList<>();
//        row.add(1);
//        for (int i = 1; i <= rowIndex; ++i) {
//            row.add(0);
//            for (int j = i; j > 0; --j) {
//                row.set(j, row.get(j) + row.get(j - 1));
//            }
//        }
//        return row;
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }
}
