import java.util.Arrays;

public class Solution1046 {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public static int lastStoneWeight(int[] stones) {
        int length = stones.length;
        if (length == 1) {
            return stones[length - 1];
        }
        Arrays.sort(stones);
        while (stones[length - 2] != 0) {
            stones[length - 1] = stones[length - 1] - stones[length - 2];
            stones[length - 2] = 0;
            Arrays.sort(stones);
        }
        return stones[length - 1];
    }
}
