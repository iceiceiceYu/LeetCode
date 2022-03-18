public class Solution2104 {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ret = 0;
        for (int i = 0; i < n; i++) {
            int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                ret += maxVal - minVal;
            }
        }
        return ret;
    }

//    public long subArrayRanges(int[] nums) {
//        int n = nums.length;
//        int[] minLeft = new int[n];
//        int[] minRight = new int[n];
//        int[] maxLeft = new int[n];
//        int[] maxRight = new int[n];
//        Deque<Integer> minStack = new ArrayDeque<>();
//        Deque<Integer> maxStack = new ArrayDeque<>();
//        for (int i = 0; i < n; i++) {
//            while (!minStack.isEmpty() && nums[minStack.peek()] > nums[i]) {
//                minStack.pop();
//            }
//            minLeft[i] = minStack.isEmpty() ? -1 : minStack.peek();
//            minStack.push(i);
//
//            // 如果 nums[maxStack.peek()] == nums[i], 那么根据定义，
//            // nums[maxStack.peek()] 逻辑上小于 nums[i]，因为 maxStack.peek() < i
//            while (!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i]) {
//                maxStack.pop();
//            }
//            maxLeft[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
//            maxStack.push(i);
//        }
//        minStack.clear();
//        maxStack.clear();
//        for (int i = n - 1; i >= 0; i--) {
//            // 如果 nums[minStack.peek()] == nums[i], 那么根据定义，
//            // nums[minStack.peek()] 逻辑上大于 nums[i]，因为 minStack.peek() > i
//            while (!minStack.isEmpty() && nums[minStack.peek()] >= nums[i]) {
//                minStack.pop();
//            }
//            minRight[i] = minStack.isEmpty() ? n : minStack.peek();
//            minStack.push(i);
//
//            while (!maxStack.isEmpty() && nums[maxStack.peek()] < nums[i]) {
//                maxStack.pop();
//            }
//            maxRight[i] = maxStack.isEmpty() ? n : maxStack.peek();
//            maxStack.push(i);
//        }
//
//        long sumMax = 0, sumMin = 0;
//        for (int i = 0; i < n; i++) {
//            sumMax += (long) (maxRight[i] - i) * (i - maxLeft[i]) * nums[i];
//            sumMin += (long) (minRight[i] - i) * (i - minLeft[i]) * nums[i];
//        }
//        return sumMax - sumMin;
//    }
}
