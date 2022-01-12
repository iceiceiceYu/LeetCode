public class Solution997 {
    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{new int[]{1, 2}}));
        System.out.println(findJudge(3, new int[][]{new int[]{1, 3}, new int[]{2, 3}}));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        for (int[] ints : trust) {
            inDegree[ints[1]]++;
            outDegree[ints[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
