import java.util.Arrays;

public class Solution344 {
    public static void main(String[] args) {
        char[] s1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] s2 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s1);
        reverseString(s2);
        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
    }


    public static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        char temp;
        while (i < j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
