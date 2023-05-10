import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1157 {
    class MajorityChecker {
        private int n;
        private int[] arr;
        private Map<Integer, List<Integer>> loc;
        private Node[] tree;

        public MajorityChecker(int[] arr) {
            this.n = arr.length;
            this.arr = arr;
            this.loc = new HashMap<>();
            for (int i = 0; i < arr.length; ++i) {
                loc.putIfAbsent(arr[i], new ArrayList<>());
                loc.get(arr[i]).add(i);
            }

            this.tree = new Node[n * 4];
            for (int i = 0; i < n * 4; i++) {
                tree[i] = new Node();
            }
            segBuild(0, 0, n - 1);
        }

        public int query(int left, int right, int threshold) {
            Node ans = new Node();
            segQuery(0, 0, n - 1, left, right, ans);
            List<Integer> pos = loc.getOrDefault(ans.x, new ArrayList<>());
            int occ = searchEnd(pos, right) - searchStart(pos, left);
            return occ >= threshold ? ans.x : -1;
        }

        private void segBuild(int id, int l, int r) {
            if (l == r) {
                tree[id] = new Node(arr[l], 1);
                return;
            }

            int mid = (l + r) / 2;
            segBuild(id * 2 + 1, l, mid);
            segBuild(id * 2 + 2, mid + 1, r);
            tree[id].add(tree[id * 2 + 1]);
            tree[id].add(tree[id * 2 + 2]);
        }

        private void segQuery(int id, int l, int r, int ql, int qr, Node ans) {
            if (l > qr || r < ql) {
                return;
            }
            if (ql <= l && r <= qr) {
                ans.add(tree[id]);
                return;
            }

            int mid = (l + r) / 2;
            segQuery(id * 2 + 1, l, mid, ql, qr, ans);
            segQuery(id * 2 + 2, mid + 1, r, ql, qr, ans);
        }

        private int searchStart(List<Integer> pos, int target) {
            int low = 0, high = pos.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (pos.get(mid) >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        private int searchEnd(List<Integer> pos, int target) {
            int low = 0, high = pos.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (pos.get(mid) > target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

    class Node {
        int x;
        int cnt;

        public Node() {
            this(0, 0);
        }

        public Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }

        public void add(Node that) {
            if (x == that.x) {
                cnt += that.cnt;
            } else if (cnt >= that.cnt) {
                cnt -= that.cnt;
            } else {
                x = that.x;
                cnt = that.cnt - cnt;
            }
        }
    }
}
