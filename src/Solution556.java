public class Solution556 {
    public int nextGreaterElement(int n) {
        int x = n, cnt = 1;
        for (; x >= 10 && x / 10 % 10 >= x % 10; x /= 10) {
            ++cnt;
        }
        x /= 10;
        if (x == 0) {
            return -1;
        }

        int targetDigit = x % 10;
        int x2 = n, cnt2 = 0;
        for (; x2 % 10 <= targetDigit; x2 /= 10) {
            ++cnt2;
        }
        x += x2 % 10 - targetDigit; // 把 x2 % 10 换到 targetDigit 上

        for (int i = 0; i < cnt; ++i, n /= 10) { // 反转 n 末尾的 cnt 个数字拼到 x 后
            int d = i != cnt2 ? n % 10 : targetDigit;
            if (x > Integer.MAX_VALUE / 10 || x == Integer.MAX_VALUE / 10 && d > 7) {
                return -1;
            }
            x = x * 10 + d;
        }
        return x;
    }
}
