import java.util.*;

public class reverseStack {
    public static void reverse(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }
        int val = st.pop();
        reverse(st);
        insertAtBottom(st,val);
    }
    public static void insertAtBottom(Stack<Integer> st, int val) {
        if (st.isEmpty()) {
            st.push(val);
            return;
        }
        int top = st.pop();
        insertAtBottom(st, val);
        st.push(top);
    }
    public static void print(Stack<Integer> st) {
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        reverse(st);
        print(st);
    }
}
