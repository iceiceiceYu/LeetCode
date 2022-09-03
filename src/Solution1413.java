public class Solution1413 {
    public int minStartValue(int[] nums) {
        int accSum = 0, accSumMin = 0;
        for (int num : nums) {
            accSum += num;
            accSumMin = Math.min(accSumMin, accSum);
        }
        return -accSumMin + 1;
    }
}
