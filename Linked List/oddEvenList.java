
//TIme Complexity-O(n)
//Space Complexity-O(1)
import java.util.HashMap;

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

public class oddEvenList {
    public static Node oddEven(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node odd = head;
        Node even = head;
        Node oddHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = oddHead;
        return head;
    }

}