public class Solution961 {
    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

    public static int repeatedNTimes(int[] A) {
        for (int k = 1; k <= 3; k++) {
            for (int i = 0; i < A.length - k; i++) {
                if (A[i] == A[i + k]) {
                    return A[i];
                }
            }
        }
        throw null;
//        Map<Integer, Integer> count = new HashMap<>();
//        for (int x : A) {
//            count.put(x, count.getOrDefault(x, 0) + 1);
//        }
//        for (int k : count.keySet()) {
//            if (count.get(k) > 1) {
//                return k;
//            }
//        }
//        throw null;
//        int[] cnt = new int[10000];
//        int flag = A.length / 2;
//        for (int i : A) {
//            cnt[i] += 1;
//            if (cnt[i] == flag) {
//                return i;
//            }
//        }
//        throw null;
    }
}
