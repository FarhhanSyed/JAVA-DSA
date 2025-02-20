class Node {
    int data;
    Node next;
    Node random;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

public class cloneLinkedList {
    public static void insertMiddle(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.data);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
    }

    public static void changeRandom(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copy = temp.next;
            if (temp.random != null) {
                copy.random = temp.random.next;
            } else {
                copy.random = null;
            }
            temp = temp.next.next;
        }
    }

    public static Node changeNext(Node head) {
        Node temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;

        while (temp != null) {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static Node cloneList(Node head) {
        if (head == null)
            return null;

        insertMiddle(head);
        changeRandom(head);
        return changeNext(head); 
    }
}
