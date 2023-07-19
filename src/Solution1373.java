public class Solution1373 {
    static final int INF = 0x3f3f3f3f;
    int res;

    static class SubTree {
        boolean isBST;
        int minValue;
        int maxValue;
        int sumValue;

        SubTree(boolean isBST, int minValue, int maxValue, int sumValue) {
            this.isBST = isBST;
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.sumValue = sumValue;
        }
    }

    public int maxSumBST(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public SubTree dfs(TreeNode root) {
        if (root == null) {
            return new SubTree(true, INF, -INF, 0);
        }
        SubTree left = dfs(root.left);
        SubTree right = dfs(root.right);

        if (left.isBST && right.isBST && root.val > left.maxValue && root.val < right.minValue) {
            int sum = root.val + left.sumValue + right.sumValue;
            res = Math.max(res, sum);
            return new SubTree(true, Math.min(left.minValue, root.val), Math.max(root.val, right.maxValue), sum);
        } else {
            return new SubTree(false, 0, 0, 0);
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
