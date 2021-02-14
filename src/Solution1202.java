import java.util.*;

public class Solution1202 {
    public static void main(String[] args) {
        List<List<Integer>> pairs1 = new ArrayList<>();
        List<List<Integer>> pairs2 = new ArrayList<>();
        List<List<Integer>> pairs3 = new ArrayList<>();
        List<Integer> list;
        list = new ArrayList<>();
        list.add(0);
        list.add(3);
        pairs1.add(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        pairs1.add(list);

        list = new ArrayList<>();
        list.add(0);
        list.add(3);
        pairs2.add(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        pairs2.add(list);
        list = new ArrayList<>();
        list.add(0);
        list.add(2);
        pairs2.add(list);

        list = new ArrayList<>();
        list.add(0);
        list.add(1);
        pairs3.add(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        pairs3.add(list);

        System.out.println(smallestStringWithSwaps("dcab", pairs1));
        System.out.println(smallestStringWithSwaps("dcab", pairs2));
        System.out.println(smallestStringWithSwaps("cba", pairs3));
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) {
            return s;
        }

        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            int index1 = pair.get(0);
            int index2 = pair.get(1);
            unionFind.union(index1, index2);
        }

        char[] charArray = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            hashMap.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(charArray[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            stringBuilder.append(hashMap.get(root).poll());
        }
        return stringBuilder.toString();
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY]++;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
