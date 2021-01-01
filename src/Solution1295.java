public class Solution1295 {
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12, 345, 2, 6, 7896}));
        System.out.println(findNumbers(new int[]{555, 901, 482, 1771}));
    }

    public static int findNumbers(int[] nums) {
        String str;
        int answer = 0;
        for (int num : nums) {
            str = num + "";
            if (str.length() % 2 == 0) {
                answer++;
            }
        }
        return answer;
    }
}
