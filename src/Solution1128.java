public class Solution1128 {
    public static void main(String[] args) {
        System.out.println(numEquivDominoPairs(new int[][]{
                new int[]{1, 2},
                new int[]{2, 1},
                new int[]{3, 4},
                new int[]{5, 6}
        }));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}
