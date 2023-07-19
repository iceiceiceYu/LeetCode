import java.util.HashMap;
import java.util.Map;

public class Solution1054 {
    public static int[] rearrangeBarcodes(int[] barcodes) {
        int length = barcodes.length;
        if (length < 2) {
            return barcodes;
        }

        Map<Integer, Integer> counts = new HashMap<>();
        int maxCount = 0;
        for (int b : barcodes) {
            counts.put(b, counts.getOrDefault(b, 0) + 1);
            maxCount = Math.max(maxCount, counts.get(b));
        }

        int evenIndex = 0;
        int oddIndex = 1;
        int halfLength = length / 2;
        int[] res = new int[length];
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int x = entry.getKey();
            int count = entry.getValue();
            while (count > 0 && count <= halfLength && oddIndex < length) {
                res[oddIndex] = x;
                count--;
                oddIndex += 2;
            }
            while (count > 0) {
                res[evenIndex] = x;
                count--;
                evenIndex += 2;
            }
        }
        return res;
    }
}
