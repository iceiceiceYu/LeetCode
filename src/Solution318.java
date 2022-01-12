import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution318 {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : words) {
            int mask = 0;
            int wordLength = s.length();
            for (int j = 0; j < wordLength; j++) {
                mask |= 1 << (s.charAt(j) - 'a');
            }
            if (wordLength > map.getOrDefault(mask, 0)) {
                map.put(mask, wordLength);
            }
        }
        int maxProd = 0;
        Set<Integer> maskSet = map.keySet();
        for (int mask1 : maskSet) {
            int wordLength1 = map.get(mask1);
            for (int mask2 : maskSet) {
                if ((mask1 & mask2) == 0) {
                    int wordLength2 = map.get(mask2);
                    maxProd = Math.max(maxProd, wordLength1 * wordLength2);
                }
            }
        }
        return maxProd;
    }
}
