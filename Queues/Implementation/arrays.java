import java.util.*;

public class arrays {
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
            return rear == -1;
        }

        public boolean isFull() {
            return rear == size - 1;
        }

        public void enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear++;
            arr[rear] = data;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int data = arr[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front++;
            }
            return data;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(3);
        System.out.println(q.size);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.dequeue();
        }
    }
}