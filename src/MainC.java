import java.util.Base64;
import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int times = input.nextInt();
        byte[] bytes = new byte[times];
        for (int i = 0; i < times; i++) {
            bytes[i] = (byte) input.nextInt();
        }
        System.out.println(Base64.getEncoder().encodeToString(bytes));
    }
}
