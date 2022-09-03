import java.util.ArrayList;
import java.util.List;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        List<Integer> stack = new ArrayList<>();
        TreeNode[] tree = new TreeNode[n];
        for (int i = 0; i < n; ++i) {
            tree[i] = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[i] > nums[stack.get(stack.size() - 1)]) {
                tree[i].left = tree[stack.get(stack.size() - 1)];
                stack.remove(stack.size() - 1);
            }
            if (!stack.isEmpty()) {
                tree[stack.get(stack.size() - 1)].right = tree[i];
            }
            stack.add(i);
        }
        return tree[stack.get(0)];
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
