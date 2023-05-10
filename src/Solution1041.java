public class Solution1041 {
    public boolean isRobotBounded(String instructions) {
        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directIndex = 0;
        int x = 0, y = 0;
        int n = instructions.length();
        for (int idx = 0; idx < n; idx++) {
            char instruction = instructions.charAt(idx);
            if (instruction == 'G') {
                x += direct[directIndex][0];
                y += direct[directIndex][1];
            } else if (instruction == 'L') {
                directIndex += 3;
                directIndex %= 4;
            } else {
                directIndex++;
                directIndex %= 4;
            }
        }
        return directIndex != 0 || (x == 0 && y == 0);
    }
}
