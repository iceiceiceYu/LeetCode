public class Solution725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int cnt = 0;
        ListNode tmp = head;

        while (tmp != null) {
            cnt++;
            tmp = tmp.next;
        }

        int divide = cnt / k, remainder = cnt % k;
        ListNode[] ans = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            ans[i] = curr;
            int partSize = divide + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return ans;
    }

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
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
