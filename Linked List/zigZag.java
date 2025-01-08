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
}

public class zigZag {
    public static Node mid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node zizzag(Node head) {
        Node mid = mid(head);

        Node cur = mid.next;
        Node prev = null;
        Node next;
        mid.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        Node left = head;
        Node right = prev;
        while (left != null && right != null) {
            Node nextLeft = left.next;
            left.next = right;
            Node nextRight = right.next;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }
        return head;
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
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node head = n1;

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        head = zizzag(head);
        print(head);
    }
}
