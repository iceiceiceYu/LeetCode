public class Solution1748 {
    public int sumOfUnique(int[] nums) {
        int ans = 0;
        int[] state = new int[101];
        for (int num : nums) {
            if (state[num] == 0) {
                ans += num;
                state[num] = 1;
            } else if (state[num] == 1) {
                ans -= num;
                state[num] = 2;
            }
        }
        return ans;

//        int ans = 0;
//        Map<Integer, Integer> state = new HashMap<>();
//        for (int num : nums) {
//            if (!state.containsKey(num)) {
//                ans += num;
//                state.put(num, 1);
//            } else if (state.get(num) == 1) {
//                ans -= num;
//                state.put(num, 2);
//            }
//        }
//        return ans;
    }
}
