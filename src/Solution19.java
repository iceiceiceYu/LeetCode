public class Solution19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        int length = 0;
//        ListNode temp = head;
//        while (temp != null) {
//            length++;
//            temp = temp.next;
//        }
//        ListNode dummy = new ListNode(0, head);
//        ListNode cur = dummy;
//        for (int i = 0; i < length - n; i++) {
//            cur = cur.next;
//        }
//        cur.next = cur.next.next;
//        return dummy.next;
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
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
