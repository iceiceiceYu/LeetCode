import java.util.HashSet;
import java.util.Set;

public class Solution217 {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : nums) {
//            if (map.get(i) != null) {
//                return true;
//            } else {
//                map.put(i, 1);
//            }
//        }
//        return false;
//        Set<Integer> set = new HashSet<>();
//        for (int i : nums) {
//            set.add(i);
//        }
//        return set.size() != nums.length;
    }
}
