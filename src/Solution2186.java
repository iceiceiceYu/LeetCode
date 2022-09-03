public class Solution2186 {
    public int minSteps(String s, String t) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnts[c - 'a']--;
        }
        int res = 0;
        for (int i : cnts) res += Math.abs(i);
        return res;
    }
}
