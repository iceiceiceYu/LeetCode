import java.util.ArrayList;
import java.util.List;

public class Solution1002 {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}).toString());
    }

    public static List<String> commonChars(String[] A) {
        List<String> answer = new ArrayList<>();
        int length = A.length;
        int[] i1 = new int[26];
        char[] temp;
        temp = A[0].toCharArray();
        for (char c : temp) {
            i1[c - 'a']++;
        }
        for (int i = 1; i < length; i++) {
            temp = A[i].toCharArray();
            int[] i2 = new int[26];
            for (char c : temp) {
                i2[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (i2[j] < i1[j]) {
                    i1[j] = i2[j];
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (i1[i] > 0) {
                for (int j = 0; j < i1[i]; j++) {
                    answer.add((char) (i + 'a') + "");
                }
            }
        }
        return answer;
    }
}
