public class Solution504 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(-7));
    }

    public static String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        int temp = Math.abs(num);
        do {
            sb.append(temp % 7);
            temp = temp / 7;
        } while (temp > 0);
        sb.reverse();
        if (num < 0) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
}
