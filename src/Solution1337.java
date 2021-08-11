import java.util.Arrays;

public class Solution1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] power = new int[m][2];
        for (int i = 0; i < m; ++i) {
            int l = 0, r = n - 1, pos = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (mat[i][mid] == 0) {
                    r = mid - 1;
                } else {
                    pos = mid;
                    l = mid + 1;
                }
            }
            power[i][0] = pos + 1;
            power[i][1] = i;
        }

        int[][] minimum = Helper.getLeastNumbers(power, k);
        Arrays.sort(minimum, (pair1, pair2) -> {
            if (pair1[0] != pair2[0]) {
                return pair1[0] - pair2[0];
            } else {
                return pair1[1] - pair2[1];
            }
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = minimum[i][1];
        }
        return ans;
    }
}

class Helper {
    public static int[][] getLeastNumbers(int[][] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[][] vec = new int[k][2];
        for (int i = 0; i < k; ++i) {
            vec[i][0] = arr[i][0];
            vec[i][1] = arr[i][1];
        }
        return vec;
    }

    private static void randomizedSelected(int[][] arr, int l, int r, int k) {
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

    // 基于随机的划分
    private static int randomizedPartition(int[][] nums, int l, int r) {
        int i = (int) (Math.random() * (r - l + 1)) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private static int partition(int[][] nums, int l, int r) {
        int[] pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (compare(nums[j], pivot) <= 0) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private static void swap(int[][] nums, int i, int j) {
        int[] temp = new int[nums[i].length];
        System.arraycopy(nums[i], 0, temp, 0, nums[i].length);
        System.arraycopy(nums[j], 0, nums[i], 0, nums[i].length);
        System.arraycopy(temp, 0, nums[j], 0, nums[i].length);
    }

    private static int compare(int[] pair, int[] pivot) {
        if (pair[0] != pivot[0]) {
            return pair[0] - pivot[0];
        } else {
            return pair[1] - pivot[1];
        }
    }
}
