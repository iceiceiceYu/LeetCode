import java.util.HashSet;
import java.util.Set;

public class Solution817 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        boolean inSet = false;
        int ans = 0;
        while (head != null) {
            if (numsSet.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    ans++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return ans;
    }

    /*
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
