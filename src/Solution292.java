public class Solution292 {
    public static void main(String[] args) {
        System.out.println(canWinNim(4));
        System.out.println(canWinNim(1));
        System.out.println(canWinNim(2));
    }

    public static boolean canWinNim(int n) {
        return (n % 4) != 0;
    }
}
