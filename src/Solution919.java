import java.util.ArrayDeque;
import java.util.Queue;

public class Solution919 {
    class CBTInserter {
        int cnt;
        TreeNode root;

        public CBTInserter(TreeNode root) {
            this.cnt = 0;
            this.root = root;

            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                cnt++;
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        public int insert(int val) {
            cnt++;
            TreeNode child = new TreeNode(val);
            TreeNode node = root;
            int highBit = 31 - Integer.numberOfLeadingZeros(cnt);
            for (int i = highBit - 1; i >= 1; --i) {
                if ((cnt & (1 << i)) != 0) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
            if ((cnt & 1) != 0) {
                node.right = child;
            } else {
                node.left = child;
            }
            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
