public class Solution1342 {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfSteps(8));
        System.out.println(numberOfSteps(123));
    }

    public static int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        int count = 0;
        do {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            count++;
        } while (num > 0);
        return count;
    }
}
