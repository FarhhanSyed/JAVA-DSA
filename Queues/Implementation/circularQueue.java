import java.util.*;

public class circularQueue {
    static class Queue {
        int[] arr;
        int rear;
        int front;
        int size;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void enqueue(int data) { // O(1)
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int dequeue() { // O(1)
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int data = arr[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return data;
        }

        public int peek() { // O(1)
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(3);
        System.out.println("size : " + q.size);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        q.enqueue(4);
        System.out.println(q.dequeue());
        q.enqueue(5);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.dequeue();
        }
    }
}