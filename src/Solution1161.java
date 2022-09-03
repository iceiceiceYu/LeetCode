import java.util.ArrayList;
import java.util.List;

public class Solution1161 {
    public int maxLevelSum(TreeNode root) {
        int ans = 1, maxSum = root.val;
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        for (int level = 1; !q.isEmpty(); level++) {
            List<TreeNode> nq = new ArrayList<>();
            int sum = 0;
            for (TreeNode node : q) {
                sum += node.val;
                if (node.left != null) {
                    nq.add(node.left);
                }
                if (node.right != null) {
                    nq.add(node.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                ans = level;
            }
            q = nq;
        }
        return ans;
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
