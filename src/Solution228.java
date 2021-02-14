import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(summaryRanges(new int[]{}));
        System.out.println(summaryRanges(new int[]{-1}));
        System.out.println(summaryRanges(new int[]{0}));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int low = i;
            i++;
            while (i < nums.length && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
//            if (low < high) {
//                answer.add(nums[low] + "->" + nums[high]);
//            } else {
//                answer.add(nums[low] + "");
//            }
            StringBuilder temp = new StringBuilder(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            answer.add(temp.toString());
        }
        return answer;
    }
}
