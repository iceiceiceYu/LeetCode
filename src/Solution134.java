public class Solution134 {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;

//        for (int i = 0; i < gas.length; i++) {
//            if (gas[i] < cost[i]) {
//                continue;
//            }
//            int remain = 0;
//            boolean isAdequate = true;
//            for (int j = i; j < gas.length; j++) {
//                remain += gas[j];
//                remain -= cost[j];
//                if (remain < 0) {
//                    isAdequate = false;
//                    break;
//                }
//            }
//            if (isAdequate) {
//                for (int j = 0; j <= i; j++) {
//                    remain += gas[j];
//                    remain -= cost[j];
//                    if (remain < 0) {
//                        break;
//                    }
//                }
//                if (remain >= 0) {
//                    return i;
//                }
//            }
//        }
//        return -1;
    }
}
