public class Solution1598 {
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                if (depth > 0) {
                    depth--;
                }
            } else {
                depth++;
            }
        }
        return depth;
    }
}
