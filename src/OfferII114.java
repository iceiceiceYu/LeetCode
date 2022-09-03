import java.util.*;

public class OfferII114 {
    Map<Character, List<Character>> edges = new HashMap<>();
    Map<Character, Integer> inDegrees = new HashMap<>();
    boolean valid = true;

    public String alienOrder(String[] words) {
        int length = words.length;
        for (String word : words) {
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                char c = word.charAt(j);
                edges.putIfAbsent(c, new ArrayList<>());
            }
        }
        for (int i = 1; i < length && valid; i++) {
            addEdge(words[i - 1], words[i]);
        }
        if (!valid) {
            return "";
        }
        Queue<Character> queue = new ArrayDeque<>();
        Set<Character> letterSet = edges.keySet();
        for (char u : letterSet) {
            if (!inDegrees.containsKey(u)) {
                queue.offer(u);
            }
        }
        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            char u = queue.poll();
            order.append(u);
            List<Character> adjacent = edges.get(u);
            for (char v : adjacent) {
                inDegrees.put(v, inDegrees.get(v) - 1);
                if (inDegrees.get(v) == 0) {
                    queue.offer(v);
                }
            }
        }
        return order.length() == edges.size() ? order.toString() : "";
    }

    private void addEdge(String before, String after) {
        int length1 = before.length(), length2 = after.length();
        int length = Math.min(length1, length2);
        int index = 0;
        while (index < length) {
            char c1 = before.charAt(index), c2 = after.charAt(index);
            if (c1 != c2) {
                edges.get(c1).add(c2);
                inDegrees.put(c2, inDegrees.getOrDefault(c2, 0) + 1);
                break;
            }
            index++;
        }
        if (index == length && length1 > length2) {
            valid = false;
        }
    }
}
