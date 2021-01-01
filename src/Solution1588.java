public class Solution1588 {
    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
        System.out.println(sumOddLengthSubarrays(new int[]{1, 2}));
        System.out.println(sumOddLengthSubarrays(new int[]{10, 11, 12}));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length, answer = 0;
        int leftOdd, rightOdd, leftEven, rightEven;
        for (int i = 0; i < len; i++) {
            leftOdd = (i + 1) / 2;
            leftEven = i / 2 + 1;
            rightOdd = (len - i) / 2;
            rightEven = (len - 1 - i) / 2 + 1;
            answer += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return answer;
//        int answer = 0;
//        int sub = 1;
//        while (sub <= arr.length) {
//            for (int i = 0; i <= arr.length - sub; i++) {
//                for (int j = 0; j < sub; j++) {
//                    answer += arr[i + j];
//                }
//            }
//            sub += 2;
//        }
//        return answer;
    }
}
