import java.util.*;

public class stackUsingDeque {
    static class Stack {
        Deque<Integer> dq;

        Stack() {
            dq = new LinkedList<>();
        }

        public boolean empty() {
            return dq.isEmpty();
        }

        public void push(int x) {
            dq.addFirst(x);
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
        Stack st = new Stack();
        st.push(2);
        st.push(1);
        st.push(3);
        while (!st.empty()) {
            System.out.println(st.pop());
        }
    }
}
