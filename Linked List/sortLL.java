//Time Complexity-O(n logn)
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

public class sortLL {
    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = middle(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;
        left = sort(left);
        right = sort(right);
        return merge(left, right);
    }

    public static Node middle(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node merge(Node left, Node right) {
        Node dummy = new Node(-1);
        Node cur = dummy;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) {
            cur.next = left;
            cur = cur.next;
        } else {
            cur.next = right;
            cur = cur.next;
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
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node head = n1;
        n1.next = n2;
        Node n3 = new Node(1);
        Node n4 = new Node(3);
        n2.next = n3;
        n3.next = n4;
        head = sort(head);
        print(head);
    }
}