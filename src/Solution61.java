public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int len = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            len++;
            tmp = tmp.next;
        }

        int add = len - k % len;
        if (add == len) {
            return head;
        }

        tmp.next = head;
        while (add-- > 0) {
            tmp = tmp.next;
        }

        ListNode ret = tmp.next;
        tmp.next = null;
        return ret;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
