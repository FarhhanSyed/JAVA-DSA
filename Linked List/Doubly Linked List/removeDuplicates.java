//Time-Complexity:O(n)
//Space-Complexity:O(1)
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public static Node head;
    public static Node tail;
}

public class removeDuplicates {
    public static Node remove(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            Node nextNode = temp.next;
            while (nextNode != null && nextNode.data == temp.data) {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(2);
        Node n5 = new Node(3);
        Node n6 = new Node(3);
        Node n7 = new Node(4);
        Node head = n1;
        n1.next = n2;
        n1.prev = null;
        n2.next = n3;
        n2.prev = n1;
        n3.next = n4;
        n3.prev = n2;
        n4.next = n5;
        n4.prev = n3;
        n5.next = n6;
        n5.prev = n4;
        n6.next = n7;
        n6.prev = n5;
        n7.next = null;
        print(head);
        remove(head);
        print(head);
    }
}
