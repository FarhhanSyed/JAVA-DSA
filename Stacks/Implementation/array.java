public class array {
    public static class Stack {
        int top = -1;
        int st[] = new int[10];

        public void push(int data) {
            if (top >= 10) {
                return;
            }
            st[++top] = data;
        }

        public int pop() {
            if (top == -1) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return st[top--];
        }

        public int peek() {
            if (top == -1) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return st[top];
        }

        public int size() {
            return top + 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.size());
    }
}
