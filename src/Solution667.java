public class Solution667 {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int idx = 0;
        for (int i = 1; i < n - k; i++) {
            answer[idx] = i;
            idx++;
        }
        for (int i = n - k, j = n; i <= j; i++, j--) {
            answer[idx] = i;
            idx++;
            if (i != j) {
                answer[idx] = j;
                idx++;
            }
        }
        return answer;
    }
}
