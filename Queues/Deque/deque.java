import java.util.*;
public class deque{
    public static void main(String args[])
    {
        Deque<Integer> dq=new LinkedList<>();
        dq.addFirst(4);
        dq.addFirst(8);
        dq.addFirst(3);
        System.out.println(dq);
        dq.addLast(1);
        dq.addLast(6);
        System.out.println(dq);
        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
        System.out.println(dq);
        dq.addFirst(76);
    }
}