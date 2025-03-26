import java.util.*;

public class queueUsingDeque {
    static class Queue {
        Deque<Integer> dq;

        Queue() {
            dq = new LinkedList<>();
        }

        public boolean empty() {
            return dq.isEmpty();
        }

        public void push(int x) {
            dq.addLast(x);
        }

        public int pop() {
            if (empty()) {
                System.out.println("Empty");
                return -1;
            }
            return dq.removeFirst();
        }

        public int peek() {
            if (empty()) {
                System.out.println("Empty");
                return -1;
            }
            return dq.getFirst();
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue();
        q.push(2);
        q.push(1);
        q.push(3);
        while (!q.empty()) {
            System.out.println(q.pop());
        }
    }
}
