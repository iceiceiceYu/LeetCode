import java.util.Scanner;

public class MainB {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] chars = input.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append((int) c).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
