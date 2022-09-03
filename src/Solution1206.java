import java.util.Arrays;
import java.util.Random;

public class Solution1206 {
    class Skiplist {
        static final int MAX_LEVEL = 32;
        static final double P_FACTOR = 0.25;
        private final SkiplistNode head;
        private int level;
        private final Random random;

        public Skiplist() {
            this.head = new SkiplistNode(-1, MAX_LEVEL);
            this.level = 0;
            this.random = new Random();
        }

        public boolean search(int target) {
            SkiplistNode curr = this.head;
            for (int i = level - 1; i >= 0; i--) {
                while (curr.forward[i] != null && curr.forward[i].val < target) {
                    curr = curr.forward[i];
                }
            }
            curr = curr.forward[0];
            return curr != null && curr.val == target;
        }

        public void add(int num) {
            SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
            Arrays.fill(update, head);
            SkiplistNode curr = this.head;
            for (int i = level - 1; i >= 0; i--) {
                while (curr.forward[i] != null && curr.forward[i].val < num) {
                    curr = curr.forward[i];
                }
                update[i] = curr;
            }
            int lv = randomLevel();
            level = Math.max(level, lv);
            SkiplistNode newNode = new SkiplistNode(num, lv);
            for (int i = 0; i < lv; i++) {
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }
        }

        public boolean erase(int num) {
            SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
            SkiplistNode curr = this.head;
            for (int i = level - 1; i >= 0; i--) {
                while (curr.forward[i] != null && curr.forward[i].val < num) {
                    curr = curr.forward[i];
                }
                update[i] = curr;
            }
            curr = curr.forward[0];
            if (curr == null || curr.val != num) {
                return false;
            }
            for (int i = 0; i < level; i++) {
                if (update[i].forward[i] != curr) {
                    break;
                }
                update[i].forward[i] = curr.forward[i];
            }
            while (level > 1 && head.forward[level - 1] == null) {
                level--;
            }
            return true;
        }

        private int randomLevel() {
            int lv = 1;
            while (random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
                lv++;
            }
            return lv;
        }
    }

    class SkiplistNode {
        int val;
        SkiplistNode[] forward;

        public SkiplistNode(int val, int maxLevel) {
            this.val = val;
            this.forward = new SkiplistNode[maxLevel];
        }
    }
}
