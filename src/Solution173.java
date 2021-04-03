import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution173 {
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
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

    class BSTIterator {
        private TreeNode cur;
        private Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new LinkedList<>();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int ret = cur.val;
            cur = cur.right;
            return ret;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }

//    class BSTIterator {
//        private int idx;
//        private List<Integer> arr;
//
//        public BSTIterator(TreeNode root) {
//            idx = 0;
//            arr = new ArrayList<>();
//            inorderTraversal(root, arr);
//        }
//
//        public int next() {
//            return arr.get(idx++);
//        }
//
//        public boolean hasNext() {
//            return idx < arr.size();
//        }
//
//        private void inorderTraversal(TreeNode root, List<Integer> arr) {
//            if (root == null) {
//                return;
//            }
//            inorderTraversal(root.left, arr);
//            arr.add(root.val);
//            inorderTraversal(root.right, arr);
//        }
//    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
