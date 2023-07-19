import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        for (int[] ints : matrix) {
            char[] arr = new char[n];
            Arrays.fill(arr, '0');
            for (int j = 0; j < n; j++) {
                arr[j] = (char) ('0' + (ints[j] ^ ints[0]));
            }
            String s = new String(arr);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        return res;
    }
}
