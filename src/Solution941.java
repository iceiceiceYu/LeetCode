public class Solution941 {
    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{2, 1}));
        System.out.println(validMountainArray(new int[]{3, 5, 5}));
        System.out.println(validMountainArray(new int[]{0, 3, 2, 1}));
    }

    public static boolean validMountainArray(int[] arr) {
        int N = arr.length;
        int i = 0;
        while (i + 1 < N && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == N - 1) {
            return false;
        }
        while (i + 1 < N && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == N - 1;
    }
}
