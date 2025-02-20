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

public class deleteAllKey {
    public static Node deleteAllOccurences(Node head, int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                if (temp == head) {
                    return temp.next;
                }
                Node front = temp.next;
                Node back = temp.prev;
                if (back != null) {
                    back.next = front;
                }
                if (front != null) {
                    front.prev = back;
                }
                temp = front;
            } else {
                temp = temp.next;
            }
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

    public static void main(String args[]) {
        Node n1 = new Node(3);
        Node n2 = new Node(4);
        Node n3 = new Node(6);
        Node n4 = new Node(4);
        Node n5 = new Node(9);
        Node n6 = new Node(4);
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
        deleteAllOccurences(head, 4);
        print(head);
    }
}
