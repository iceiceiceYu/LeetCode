public class Solution1486 {
    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
        System.out.println(xorOperation(4, 3));
        System.out.println(xorOperation(1, 7));
        System.out.println(xorOperation(10, 5));
    }

    public static int xorOperation(int n, int start) {
        int answer = start;
        for (int i = 1; i < n; i++) {
            answer = answer ^ (start + 2 * i);
        }
        return answer;
    }
}
