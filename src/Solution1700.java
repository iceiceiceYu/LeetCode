import java.util.Arrays;

public class Solution1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;
        for (int sandwich : sandwiches) {
            if (sandwich == 0 && s0 > 0) {
                s0--;
            } else if (sandwich == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }
}
