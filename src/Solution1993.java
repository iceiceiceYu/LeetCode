import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1993 {
    class LockingTree {
        private int[] parent;
        private int[] lockNodeUser;
        private List<Integer>[] children;

        public LockingTree(int[] parent) {
            int n = parent.length;
            this.parent = parent;
            this.lockNodeUser = new int[n];
            Arrays.fill(this.lockNodeUser, -1);
            this.children = new List[n];
            for (int i = 0; i < n; i++) {
                this.children[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                int p = parent[i];
                if (p != -1) {
                    children[p].add(i);
                }
            }
        }

        public boolean lock(int num, int user) {
            if (lockNodeUser[num] == -1) {
                lockNodeUser[num] = user;
                return true;
            }
            return false;
        }

        public boolean unlock(int num, int user) {
            if (lockNodeUser[num] == user) {
                lockNodeUser[num] = -1;
                return true;
            }
            return false;
        }

        public boolean upgrade(int num, int user) {
            boolean res = lockNodeUser[num] == -1 && !hasLockedAncestor(num) && checkAndUnlockDescendant(num);
            if (res) {
                lockNodeUser[num] = user;
            }
            return res;
        }

        private boolean hasLockedAncestor(int num) {
            num = parent[num];
            while (num != -1) {
                if (lockNodeUser[num] != -1) {
                    return true;
                }
                num = parent[num];
            }
            return false;
        }

        private boolean checkAndUnlockDescendant(int num) {
            boolean res = lockNodeUser[num] != -1;
            lockNodeUser[num] = -1;
            for (int child : children[num]) {
                res |= checkAndUnlockDescendant(child);
            }
            return res;
        }
    }
}
