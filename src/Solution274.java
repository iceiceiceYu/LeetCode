import java.util.Arrays;

public class Solution274 {
    public int hIndex(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) {
                counter[n]++;
            } else {
                counter[citation]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;

//        Arrays.sort(citations);
//        int h = 0, i = citations.length - 1;
//        while (i >= 0 && citations[i] > h) {
//            h++;
//            i--;
//        }
//        return h;
    }
}
