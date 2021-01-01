public class Solution387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        int[] ints = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            ints[c - 'a'] = ints[c - 'a'] + 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (ints[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
