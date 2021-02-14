import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution989 {
    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println(addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println(addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
//        List<Integer> res = new ArrayList<Integer>();
//        int n = A.length;
//        for (int i = n - 1; i >= 0; --i) {
//            int sum = A[i] + K % 10;
//            K /= 10;
//            if (sum >= 10) {
//                K++;
//                sum -= 10;
//            }
//            res.add(sum);
//        }
//        for (; K > 0; K /= 10) {
//            res.add(K % 10);
//        }
//        Collections.reverse(res);
//        return res;

        List<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        for (int i = n - 1; i >= 0 || K > 0; --i, K /= 10) {
            if (i >= 0) {
                K += A[i];
            }
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }
}
