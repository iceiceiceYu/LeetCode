import java.util.*;

public class Solution1203 {
    public static void main(String[] args) {
        List<List<Integer>> beforeItems1 = new ArrayList<>();
        List<List<Integer>> beforeItems2 = new ArrayList<>();
        List<Integer> list;
        list = new ArrayList<>();
        beforeItems1.add(list);
        list = new ArrayList<>();
        list.add(6);
        beforeItems1.add(list);
        list = new ArrayList<>();
        list.add(5);
        beforeItems1.add(list);
        list = new ArrayList<>();
        list.add(6);
        beforeItems1.add(list);
        list = new ArrayList<>();
        list.add(3);
        list.add(6);
        beforeItems1.add(list);
        list = new ArrayList<>();
        beforeItems1.add(list);
        list = new ArrayList<>();
        beforeItems1.add(list);
        list = new ArrayList<>();
        beforeItems1.add(list);

        list = new ArrayList<>();
        beforeItems2.add(list);
        list = new ArrayList<>();
        list.add(6);
        beforeItems2.add(list);
        list = new ArrayList<>();
        list.add(5);
        beforeItems2.add(list);
        list = new ArrayList<>();
        list.add(6);
        beforeItems2.add(list);
        list = new ArrayList<>();
        list.add(3);
        beforeItems2.add(list);
        list = new ArrayList<>();
        beforeItems2.add(list);
        list = new ArrayList<>();
        list.add(4);
        beforeItems2.add(list);
        list = new ArrayList<>();
        beforeItems2.add(list);

        System.out.println(Arrays.toString(sortItems(8, 2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1}, beforeItems1)));
        System.out.println(Arrays.toString(sortItems(8, 2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1}, beforeItems2)));

    }

    public static int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m;
                m++;
            }
        }

        ArrayList[] groupAdj = new ArrayList[m];
        ArrayList[] itemAdj = new ArrayList[n];
        for (int i = 0; i < m; i++) {
            groupAdj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            itemAdj[i] = new ArrayList<>();
        }

        int[] groupsInDegree = new int[m];
        int[] itemsInDegree = new int[n];

        int len = group.length;
        for (int i = 0; i < len; i++) {
            int currentGroup = group[i];
            for (int beforeItem : beforeItems.get(i)) {
                int beforeGroup = group[beforeItem];
                if (beforeGroup != currentGroup) {
                    groupAdj[beforeGroup].add(currentGroup);
                    groupsInDegree[currentGroup]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (Integer item : beforeItems.get(i)) {
                itemAdj[item].add(i);
                itemsInDegree[i]++;
            }
        }

        List<Integer> groupsList = topologicalSort(groupAdj, groupsInDegree, m);
        if (groupsList.size() == 0) {
            return new int[0];
        }
        List<Integer> itemsList = topologicalSort(itemAdj, itemsInDegree, n);
        if (itemsList.size() == 0) {
            return new int[0];
        }

        Map<Integer, List<Integer>> groups2Items = new HashMap<>();
        for (Integer item : itemsList) {
            groups2Items.computeIfAbsent(group[item], key -> new ArrayList<>()).add(item);
        }

        List<Integer> res = new ArrayList<>();
        for (Integer groupId : groupsList) {
            List<Integer> items = groups2Items.getOrDefault(groupId, new ArrayList<>());
            res.addAll(items);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private static List<Integer> topologicalSort(List<Integer>[] adj, int[] inDegree, int n) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer front = queue.poll();
            res.add(front);
            for (int successor : adj[front]) {
                inDegree[successor]--;
                if (inDegree[successor] == 0) {
                    queue.offer(successor);
                }
            }
        }

        if (res.size() == n) {
            return res;
        }
        return new ArrayList<>();
    }
}
