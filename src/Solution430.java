public class Solution430 {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            if (curr.child != null) {
                Node childLast = dfs(curr.child);

                curr.next = curr.child;
                curr.child.prev = curr;

                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                curr.child = null;
                last = childLast;
            } else {
                last = curr;
            }
            curr = next;
        }
        return last;
    }

    /*
     * Definition for a Node.
     */
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
