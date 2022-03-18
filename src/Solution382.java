import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution382 {
    class Solution {
        List<Integer> list;
        Random random;

        public Solution(ListNode head) {
            list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            random = new Random();
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
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
