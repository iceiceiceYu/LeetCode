public class Solution371 {
    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
        System.out.println(getSum(-2, 3));
    }

    public static int getSum(int a, int b) {
        int sum = 0;
        if (a >= 0) {
            for (int i = 0; i < a; i++) {
                sum++;
            }
        } else {
            for (int i = 0; i > a; i--) {
                sum--;
            }
        }
        if (b >= 0) {
            for (int i = 0; i < b; i++) {
                sum++;
            }
        } else {
            for (int i = 0; i > b; i--) {
                sum--;
            }
        }
        return sum;
    }
}
