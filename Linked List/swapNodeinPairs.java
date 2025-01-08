//Time Complexity-O(n)
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

public class swapNodeinPairs {
    public static Node swap(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node dummy = new Node(-1);
        dummy.next = head;
        Node cur = dummy;
        while (cur.next != null) {
            Node first = cur.next;
            Node second = cur.next.next;

            cur.next = second;
            first.next = second.next;
            second.next = first;

            cur = first;
        }
        return dummy.next;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node head = n1;
        n1.next = n2;
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n2.next = n3;
        n3.next = n4;
        head = swap(head);
        print(head);
    }
}