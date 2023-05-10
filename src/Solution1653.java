public class Solution1653 {
    public int minimumDeletions(String s) {
        int leftB = 0, rightA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                rightA++;
            }
        }
        int res = rightA;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                rightA--;
            } else {
                leftB++;
            }
            res = Math.min(res, leftB + rightA);
        }
        return res;
    }
}
