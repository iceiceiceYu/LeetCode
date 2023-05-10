public class Solution2399 {
    public boolean checkDistances(String s, int[] distance) {
        int[] firstIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (firstIndex[idx] != 0 && i - firstIndex[idx] != distance[idx]) {
                return false;
            }
            firstIndex[idx] = i + 1;
        }
        return true;
    }
}
