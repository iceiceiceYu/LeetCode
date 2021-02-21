import java.util.TreeMap;

public class Solution1438 {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int left = 0, right = 0, size = 0, maxSize = 0, len = nums.length;
        while (right < len) {
            int item = nums[right];
            treeMap.put(item, treeMap.getOrDefault(item, 0) + 1);
            right++;
            while (left <= right && treeMap.lastKey() - treeMap.firstKey() > limit) {
                if (treeMap.get(nums[left]) == 1) {
                    treeMap.remove(nums[left]);
                } else {
                    treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
                }
                left++;
            }
            maxSize = Math.max(maxSize, right - left);
        }
        return maxSize;
    }
}
