import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution449 {
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            postOrder(root, list);
            String str = list.toString();
            return str.substring(1, str.length() - 1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] arr = data.split(", ");
            Deque<Integer> stack = new ArrayDeque<>();
            int length = arr.length;
            for (String s : arr) {
                stack.push(Integer.parseInt(s));
            }
            return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
        }

        private void postOrder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.val);
        }

        private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
            if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
                return null;
            }
            int val = stack.pop();
            TreeNode root = new TreeNode(val);
            root.right = construct(val, upper, stack);
            root.left = construct(lower, val, stack);
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

        TreeNode(int x) {
            val = x;
        }
    }
}
