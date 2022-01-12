import java.util.HashMap;

public class Solution594 {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        for (int key : cnt.keySet()) {
            if (cnt.containsKey(key + 1)) {
                res = Math.max(res, cnt.get(key) + cnt.get(key + 1));
            }
        }
        return res;
    }

//    public int findLHS(int[] nums) {
//        Arrays.sort(nums);
//        int begin = 0;
//        int res = 0;
//        for (int end = 0; end < nums.length; end++) {
//            while (nums[end] - nums[begin] > 1) {
//                begin++;
//            }
//            if (nums[end] - nums[begin] == 1) {
//                res = Math.max(res, end - begin + 1);
//            }
//        }
//        return res;
//    }
}
