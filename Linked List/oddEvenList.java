
//TIme Complexity-O(n/2)
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
        Node slow = head;
        Node fast = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}