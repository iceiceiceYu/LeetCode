public class Solution189 {
    public static void rotate(int[] nums, int k) {
//        int n = nums.length;
//        int[] newArr = new int[n];
//        for (int i = 0; i < n; ++i) {
//            newArr[(i + k) % n] = nums[i];
//        }
//        System.arraycopy(newArr, 0, nums, 0, n);

//        int n = nums.length;
//        k = k % n;
//        int count = gcd(k, n);
//        for (int start = 0; start < count; ++start) {
//            int current = start;
//            int prev = nums[start];
//            do {
//                int next = (current + k) % n;
//                int temp = nums[next];
//                nums[next] = prev;
//                prev = temp;
//                current = next;
//            } while (start != current);
//        }

        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

//    public static int gcd(int x, int y) {
//        return y > 0 ? gcd(y, x % y) : x;
//    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
