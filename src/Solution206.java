public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        if (node == null || node.next == null) {
            return node;
        } else {
            ListNode next = node.next;
            ListNode nextToNext = next.next;
            node.next = null;
            while (nextToNext != null) {
                next.next = node;
                node = next;
                next = nextToNext;
                nextToNext = nextToNext.next;
            }
            next.next = node;
            return next;
        }
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
