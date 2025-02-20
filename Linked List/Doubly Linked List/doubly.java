public class doubly {
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addMiddle(int idx, int data) {
        Node temp = head;
        int i = 1;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        Node newNode = new Node(data);
        size++;
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = tail = null;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    public void deleteByIdx(int idx) {
        if (idx < 1) {
            System.out.println("Index must be greater than 1 or greater");
            return;
        }

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        int i = 1;
        Node temp = head;

        while (temp != null) {
            if (i == idx)
                break;
            temp = temp.next;
            i++;
        }

        if (temp == null) {
            System.out.println("Index out of range.");
            return;
        }

        Node back = temp.prev;
        Node front = temp.next;
        if (back == null && front == null) {
            head = null;
            return;
        } else if (back == null) {
            deleteFirst();
            return;
        } else if (front == null) {
            deleteLast();
            return;
        }
        back.next = front;
        front.prev = back;
        temp.next = null;
        temp.prev = null;
    }

    public void reverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            return;
        }
        Node cur = head;
        Node prev = null;
        Node nextt;
        while (cur != null) {
            nextt = cur.next;
            cur.next = prev;
            cur.prev = nextt;

            prev = cur;
            cur = nextt;
        }
        head = prev;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        doubly list = new doubly();
        list.addLast(3);
        // list.addLast(4);
        // list.addLast(5);
        // list.addLast(6);
        // list.addLast(7);
        list.print();
        list.deleteByIdx(1);
        list.print();
        System.out.println(list.size);
    }
}
