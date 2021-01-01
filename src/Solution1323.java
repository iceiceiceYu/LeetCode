public class Solution1323 {
    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
        System.out.println(maximum69Number(9996));
        System.out.println(maximum69Number(9999));
    }

    public static int maximum69Number(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        int length = sb.length();
        for (int i = 0; i < length; i++) {
            if (sb.charAt(i) == '6') {
                sb.replace(i, i + 1, "9");
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
