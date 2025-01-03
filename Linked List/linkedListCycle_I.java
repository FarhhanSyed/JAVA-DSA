import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public static Node head;
}

public class linkedListCycle_I {
    public static boolean cycleI(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        Node n3 = new Node(3);
        n2.next = n3;
        Node n4 = new Node(4);
        n3.next = n4;
        Node n5 = new Node(5);
        n4.next = n5;
        n5.next = n2;
        Node head = n1;
        System.out.println(cycleI(n1));
    }
}