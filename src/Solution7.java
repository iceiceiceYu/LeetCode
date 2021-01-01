public class Solution7 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MIN_VALUE));
    }

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        if (x < 0) {
            sb.deleteCharAt(0);
        }
        sb.reverse();
        if (x < 0) {
            sb.insert(0, "-");
        }
        long answer = Long.parseLong(sb.toString());
        if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) answer;
    }
}
