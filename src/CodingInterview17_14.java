import java.util.Random;

public class CodingInterview17_14 {
//    public int[] smallestK(int[] arr, int k) {
//        int[] vec = new int[k];
//        Arrays.sort(arr);
//        System.arraycopy(arr, 0, vec, 0, k);
//        return vec;
//    }

//    public int[] smallestK(int[] arr, int k) {
//        int[] vec = new int[k];
//        if (k == 0) {
//            return vec;
//        }
//        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
//        for (int i = 0; i < k; ++i) {
//            queue.offer(arr[i]);
//        }
//        for (int i = k; i < arr.length; ++i) {
//            if (queue.peek() > arr[i]) {
//                queue.poll();
//                queue.offer(arr[i]);
//            }
//        }
//        for (int i = 0; i < k; ++i) {
//            vec[i] = queue.poll();
//        }
//        return vec;
//    }

    public int[] smallestK(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[] vec = new int[k];
        System.arraycopy(arr, 0, vec, 0, k);
        return vec;
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
