public class Solution1026 {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int mi, int ma) {
        if (root == null) {
            return 0;
        }
        int diff = Math.max(Math.abs(root.val - mi), Math.abs(root.val - ma));
        mi = Math.min(mi, root.val);
        ma = Math.max(ma, root.val);
        diff = Math.max(diff, dfs(root.left, mi, ma));
        diff = Math.max(diff, dfs(root.right, mi, ma));
        return diff;
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
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
