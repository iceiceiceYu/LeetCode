import java.util.*;

public class Solution349 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1, set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        list.retainAll(set2);
        set1 = new HashSet<>(list);
        return set1.stream().mapToInt(i -> i).toArray();

//        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
//        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }
}
