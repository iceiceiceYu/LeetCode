import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int best = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; ++i) {
            int delta = arr[i + 1] - arr[i];
            if (delta < best) {
                best = delta;
                ans.clear();
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            } else if (delta == best) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            }
        }
        return ans;
    }
}
