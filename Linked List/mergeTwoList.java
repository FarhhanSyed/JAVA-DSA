//Time Complexity-O(n+m)
//Space Complexity-O(1)
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public static Node head;
    public static Node tail;
}

public class mergeTwoList {
    public static Node sort(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) {
            cur.next = head1;
        } else {
            cur.next = head2;
        }
        return dummy.next;
    }
}
