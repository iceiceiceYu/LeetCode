import java.util.Scanner;

public class MainE {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int p = input.nextInt();
        if (n + p == 1) {
            System.out.println(0);
        } else {
            long remainder = 1;
            long multiply = 1;
            for (long i = n + p; i >= n + 1; i--) {
                multiply *= i;
                multiply = multiply % n;
                remainder = (multiply + remainder) % n;
            }
            System.out.println(remainder);
        }
    }
}
