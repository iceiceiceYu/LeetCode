public class Solution476 {
    public int findComplement(int num) {
        int highBit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                highBit = i;
            } else {
                break;
            }
        }
        int mask = highBit == 30 ? 0x7fffffff : (1 << (highBit + 1)) - 1;
        return num ^ mask;
    }
}
