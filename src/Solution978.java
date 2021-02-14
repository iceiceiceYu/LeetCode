public class Solution978 {
    //    public int maxTurbulenceSize(int[] arr) {
//        int n = arr.length;
//        int ret = 1;
//        int left = 0, right = 0;
//
//        while (right < n - 1) {
//            if (left == right) {
//                if (arr[left] == arr[left + 1]) {
//                    left++;
//                }
//                right++;
//            } else {
//                if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
//                    right++;
//                } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
//                    right++;
//                } else {
//                    left = right;
//                }
//            }
//            ret = Math.max(ret, right - left + 1);
//        }
//        return ret;
//    }
//    public int maxTurbulenceSize(int[] arr) {
//        int n = arr.length;
//        int[][] dp = new int[n][2];
//        dp[0][0] = dp[0][1] = 1;
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = dp[i][1] = 1;
//            if (arr[i - 1] > arr[i]) {
//                dp[i][0] = dp[i - 1][1] + 1;
//            } else if (arr[i - 1] < arr[i]) {
//                dp[i][1] = dp[i - 1][0] + 1;
//            }
//        }
//
//        int ret = 1;
//        for (int i = 0; i < n; i++) {
//            ret = Math.max(ret, dp[i][0]);
//            ret = Math.max(ret, dp[i][1]);
//        }
//        return ret;
//    }

    public int maxTurbulenceSize(int[] arr) {
        int ret = 1;
        int n = arr.length;
        int dp0 = 1, dp1 = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                dp0 = dp1 + 1;
                dp1 = 1;
            } else if (arr[i - 1] < arr[i]) {
                dp1 = dp0 + 1;
                dp0 = 1;
            } else {
                dp0 = 1;
                dp1 = 1;
            }
            ret = Math.max(ret, dp0);
            ret = Math.max(ret, dp1);
        }
        return ret;
    }
}
