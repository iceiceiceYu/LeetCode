public class Solution335 {
    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;

        // 处理第 1 种情况
        int i = 0;
        while (i < n && (i < 2 || distance[i] > distance[i - 2])) {
            ++i;
        }

        if (i == n) {
            return false;
        }

        // 处理第 j 次移动的情况
        if ((i == 3 && distance[i] == distance[i - 2])
                || (i >= 4 && distance[i] >= distance[i - 2] - distance[i - 4])) {
            distance[i - 1] -= distance[i - 3];
        }
        ++i;

        // 处理第 2 种情况
        while (i < n && distance[i] < distance[i - 2]) {
            ++i;
        }

        return i != n;
    }

//    public boolean isSelfCrossing(int[] distance) {
//        int n = distance.length;
//        for (int i = 3; i < n; ++i) {
//            // 第 1 类路径交叉的情况
//            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
//                return true;
//            }
//
//            // 第 2 类路径交叉的情况
//            if (i == 4 && (distance[3] == distance[1]
//                    && distance[4] >= distance[2] - distance[0])) {
//                return true;
//            }
//
//            // 第 3 类路径交叉的情况
//            if (i >= 5 && (distance[i - 3] - distance[i - 5] <= distance[i - 1]
//                    && distance[i - 1] <= distance[i - 3]
//                    && distance[i] >= distance[i - 2] - distance[i - 4]
//                    && distance[i - 2] > distance[i - 4])) {
//                return true;
//            }
//        }
//        return false;
//    }
}
