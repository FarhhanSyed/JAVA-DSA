//TIme Complexity-O(n)
//Space Complexity-O(1)
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = next;
    }

    public static Node head;
    public static Node tail;
}

public class loopLength {
    public static int loopLen(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return length(slow);
            }
        }
        return -1;
    }

    public static int length(Node loopNode) {
        Node temp = loopNode;
        int count = 1;
        while (temp.next != loopNode) {
            count++;
            temp = temp.next;
        }
        return count;
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
        System.out.println(loopLen(head));
    }
}
