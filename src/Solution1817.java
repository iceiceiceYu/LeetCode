import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> activeMinutes = new HashMap<>();
        for (int[] log : logs) {
            int id = log[0], time = log[1];
            activeMinutes.putIfAbsent(id, new HashSet<>());
            activeMinutes.get(id).add(time);
        }
        int[] answer = new int[k];
        for (Set<Integer> minutes : activeMinutes.values()) {
            int activeCount = minutes.size();
            answer[activeCount - 1]++;
        }
        return answer;
    }
}
