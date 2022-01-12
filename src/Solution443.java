public class Solution443 {
    public int compress(char[] chars) {
        int slow = 0, fast = 0, count = 0, cnt = 0;
        while (fast < chars.length) {
            while (fast < chars.length && chars[fast] == chars[slow]) {
                count++;
                fast++;
            }
            if (count == 1) {
                chars[cnt++] = chars[slow];
            } else {
                String temp = Integer.toString(count);
                chars[cnt++] = chars[slow];
                for (int i = 0; i < temp.length(); i++) {
                    chars[cnt++] = temp.charAt(i);
                }
            }
            count = 0;
            slow = fast;
        }
        return cnt;
    }
}
