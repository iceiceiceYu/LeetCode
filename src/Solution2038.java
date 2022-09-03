public class Solution2038 {
    public boolean winnerOfGame(String colors) {
        int[] freq = {0, 0};
        char cur = 'C';
        int cnt = 0;
        int length = colors.length();
        for (int i = 0; i < length; i++) {
            char c = colors.charAt(i);
            if (c != cur) {
                cur = c;
                cnt = 1;
            } else {
                cnt += 1;
                if (cnt >= 3) {
                    freq[cur - 'A'] += 1;
                }
            }
        }
        return freq[0] > freq[1];
    }
}
