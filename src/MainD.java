import java.util.Scanner;

public class MainD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] answer = new int[16];
        compute(n, answer);
        process(n, answer);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    private static void compute(int n, int[] answer) {
        if (n == 0) {
            return;
        }
        int count = 0;
        while (n >= (int) Math.pow(3, count)) {
            count++;
        }
        int curr = (int) Math.pow(3, count - 1);
        int divide = n / curr;
        int remain = n - divide * curr;
        if (divide == 1) {
            answer[count - 1] += 1;
            compute(remain, answer);
        }
        if (divide == 2) {
            answer[count - 1] -= 1;
            answer[count] += 1;
            compute(remain, answer);
        }
    }

    private static void process(int n, int[] answer) {
        for (int i = 0; i < 15; i++) {
            if (answer[i] > 1) {
                answer[i] = -1;
                answer[i + 1] += 1;
            }
        }
    }
}
