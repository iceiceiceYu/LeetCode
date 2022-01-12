public class Solution551 {
    public boolean checkRecord(String s) {
        int countAbsent = 0, countLate = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                countAbsent++;
                if (countAbsent >= 2) {
                    return false;
                }
            }
            if (c == 'L') {
                countLate++;
                if (countLate >= 3) {
                    return false;
                }
            } else {
                countLate = 0;
            }
        }
        return true;
    }
}
