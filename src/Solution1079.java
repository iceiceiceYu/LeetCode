import java.util.*;

public class Solution1079 {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> count = new HashMap<>();
        for (char t : tiles.toCharArray()) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }
        Set<Character> tile = new HashSet<>(count.keySet());
        return dfs(tiles.length(), count, tile) - 1;
    }

    private int dfs(int i, Map<Character, Integer> count, Set<Character> tile) {
        if (i == 0) {
            return 1;
        }
        int res = 1;
        for (char t : tile) {
            if (count.get(t) > 0) {
                count.put(t, count.get(t) - 1);
                res += dfs(i - 1, count, tile);
                count.put(t, count.get(t) + 1);
            }
        }
        return res;
    }
}
