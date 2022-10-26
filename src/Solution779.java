public class Solution779 {
    public int kthGrammar(int n, int k) {
        k--;
        int ans = 0;
        while (k > 0) {
            k &= k - 1;
            ans ^= 1;
        }
        return ans;
    }
}
