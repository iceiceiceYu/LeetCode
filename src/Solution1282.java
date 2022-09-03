import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        int n = groupSizes.length;
        for (int i = 0; i < n; i++) {
            int size = groupSizes[i];
            groups.putIfAbsent(size, new ArrayList<>());
            groups.get(size).add(i);
        }
        List<List<Integer>> groupList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
            int size = entry.getKey();
            List<Integer> people = entry.getValue();
            int groupCount = people.size() / size;
            for (int i = 0; i < groupCount; i++) {
                List<Integer> group = new ArrayList<>();
                int start = i * size;
                for (int j = 0; j < size; j++) {
                    group.add(people.get(start + j));
                }
                groupList.add(group);
            }
        }
        return groupList;
    }
}
