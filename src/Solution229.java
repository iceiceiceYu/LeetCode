import java.util.ArrayList;
import java.util.List;

public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;

        for (int num : nums) {
            if (vote1 > 0 && num == element1) { //如果该元素为第一个元素，则计数加1
                vote1++;
            } else if (vote2 > 0 && num == element2) { //如果该元素为第二个元素，则计数加1
                vote2++;
            } else if (vote1 == 0) { // 选择第一个元素
                element1 = num;
                vote1++;
            } else if (vote2 == 0) { // 选择第二个元素
                element2 = num;
                vote2++;
            } else { //如果三个元素均不相同，则相互抵消1次
                vote1--;
                vote2--;
            }
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == element1) {
                cnt1++;
            }
            if (vote2 > 0 && num == element2) {
                cnt2++;
            }
        }
        // 检测元素出现的次数是否满足要求
        List<Integer> ans = new ArrayList<>();
        if (vote1 > 0 && cnt1 > nums.length / 3) {
            ans.add(element1);
        }
        if (vote2 > 0 && cnt2 > nums.length / 3) {
            ans.add(element2);
        }

        return ans;
    }

//    public List<Integer> majorityElement(int[] nums) {
//        HashMap<Integer, Integer> cnt = new HashMap<>();
//        for (int num : nums) {
//            if (cnt.containsKey(num)) {
//                cnt.put(num, cnt.get(num) + 1);
//            } else {
//                cnt.put(num, 1);
//            }
//        }
//        List<Integer> ans = new ArrayList<>();
//        for (int x : cnt.keySet()) {
//            if (cnt.get(x) > nums.length / 3) {
//                ans.add(x);
//            }
//        }
//        return ans;
//    }
}
