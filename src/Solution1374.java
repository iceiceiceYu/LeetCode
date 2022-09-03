public class Solution1374 {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            return sb.toString();
        }
        for (int i = 0; i < n - 1; i++) {
            sb.append("a");
        }
        return sb.append("b").toString();
    }
}
