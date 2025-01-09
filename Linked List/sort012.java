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

public class sort012 {
    public static Node sort(Node head) {
        Node zDummy = new Node(0);
        Node oDummy = new Node(1);
        Node tDummy = new Node(2);

        Node zero = zDummy, one = oDummy, two = tDummy;

        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = (oDummy.next != null) ? oDummy.next : tDummy.next;
        one.next = (tDummy.next != null) ? tDummy.next : null;
        two.next = null;
        return zDummy.next;
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
        Node n1 = new Node(2);
        Node n2 = new Node(1);
        Node n3 = new Node(0);
        Node n4 = new Node(2);
        Node n5 = new Node(1);
        Node n6 = new Node(0);
        Node n7 = new Node(0);
        Node n8 = new Node(1);
        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        head = sort(head);
        print(head);
    }
}
