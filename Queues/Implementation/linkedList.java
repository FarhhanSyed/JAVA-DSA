import java.util.*;

public class linkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        Node head;
        Node tail;

        Queue() {
            head = tail = null;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void enqueue(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int val = head.data;
            head = head.next;
            if (head == tail) {
                head = tail = null;
            }
            return val;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is EMpty");
                return -1;
            }
            return head.data;
        }

        public void print() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.err.println("null");
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.print();
    }
}
