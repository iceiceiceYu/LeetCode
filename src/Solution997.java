public class Solution997 {
    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{new int[]{1, 2}}));
        System.out.println(findJudge(3, new int[][]{new int[]{1, 3}, new int[]{2, 3}}));
    }

    public static int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];
        for (int[] ints : trust) {
            inDegree[ints[1]]++;
            outDegree[ints[0]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
