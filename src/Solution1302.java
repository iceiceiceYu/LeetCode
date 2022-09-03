public class Solution1302 {
    int maxLevel = -1;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level > maxLevel) {
            maxLevel = level;
            sum = node.val;
        } else if (level == maxLevel) {
            sum += node.val;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
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
