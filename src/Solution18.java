import java.util.*;

public class Solution18 {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2, 0}, 0).toString());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Set<List<Integer>> temp = new HashSet<>();
        int length = nums.length;
        if (length < 4) {
            return answer;
        } else {
            Arrays.sort(nums);
            for (int i = 0; i < length - 3; i++) {
                for (int j = i + 1; j < length - 2; j++) {
                    for (int k = j + 1; k < length - 1; k++) {
                        for (int l = k + 1; l < length; l++) {
                            List<Integer> integers = new ArrayList<>();
                            if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                                integers.add(nums[i]);
                                integers.add(nums[j]);
                                integers.add(nums[k]);
                                integers.add(nums[l]);
                                temp.add(integers);
                            }
                        }
                    }
                }
            }
            answer = new ArrayList<>(temp);
        }
        return answer;
    }
}
