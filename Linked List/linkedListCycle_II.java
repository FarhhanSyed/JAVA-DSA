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

public class linkedListCycle_II {
    public static int cycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                Node entry = head;
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow.data;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        n1.next = n2;
        Node n3 = new Node(0);
        Node n4 = new Node(4);
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        Node head = n1;
        System.out.println("Tail connects to node val : " + cycle(head));
    }
}