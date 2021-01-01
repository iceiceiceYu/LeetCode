public class Solution9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }


    public static boolean isPalindrome(int x) {
        StringBuilder sb = (new StringBuilder(x + "")).reverse();
        return (x + "").equals(sb.toString());
    }
}
