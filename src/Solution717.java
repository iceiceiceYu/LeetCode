public class Solution717 {
    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
}
