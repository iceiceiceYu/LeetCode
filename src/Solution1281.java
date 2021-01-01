public class Solution1281 {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
        System.out.println(subtractProductAndSum(4421));
    }

    public static int subtractProductAndSum(int n) {
        int mul = 1, sum = 0;
        do {
            mul *= n % 10;
            sum += n % 10;
            n /= 10;
        } while (n > 0);
//        String str = n + "";
//        char[] chars = str.toCharArray();
//        for (char c : chars) {
//            mul *= Integer.parseInt(c + "");
//            sum += Integer.parseInt(c + "");
//        }
        return mul - sum;
    }
}
