import java.util.HashMap;
import java.util.Map;

public class Solution138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }

//    Map<Node, Node> cachedNode = new HashMap<>();
//
//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return null;
//        }
//        if (!cachedNode.containsKey(head)) {
//            Node headNew = new Node(head.val);
//            cachedNode.put(head, headNew);
//            headNew.next = copyRandomList(head.next);
//            headNew.random = copyRandomList(head.random);
//        }
//        return cachedNode.get(head);
//    }

    /*
    // Definition for a Node.
    */
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
