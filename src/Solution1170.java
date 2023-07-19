public class Solution1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] count = new int[12];
        for (String s : words) {
            count[f(s)]++;
        }
        for (int i = 9; i >= 1; i--) {
            count[i] += count[i + 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String s = queries[i];
            res[i] = count[f(s) + 1];
        }
        return res;
    }

    public int f(String s) {
        int cnt = 0;
        char ch = 'z';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < ch) {
                ch = c;
                cnt = 1;
            } else if (c == ch) {
                cnt++;
            }
        }
        return cnt;
    }
}
