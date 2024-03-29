public class OfferII29 {
    class Solution {
        public Node insert(Node head, int insertVal) {
            Node node = new Node(insertVal);
            if (head == null) {
                node.next = node;
                return node;
            }
            if (head.next == head) {
                head.next = node;
                node.next = head;
                return head;
            }
            Node curr = head, next = head.next;
            while (next != head) {
                if (insertVal >= curr.val && insertVal <= next.val) {
                    break;
                }
                if (curr.val > next.val) {
                    if (insertVal > curr.val || insertVal < next.val) {
                        break;
                    }
                }
                curr = curr.next;
                next = next.next;
            }
            curr.next = node;
            node.next = next;
            return head;
        }
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
