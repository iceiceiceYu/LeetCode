public class Solution2011 {
    public int finalValueAfterOperations(String[] operations) {
        int cnt = 0;
        for (String op : operations) {
            if (op.equals("X++") || op.equals("++X")) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return cnt;
    }
}
