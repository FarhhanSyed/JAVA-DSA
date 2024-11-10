import java.util.ArrayList;

public class monotonic {
    public static boolean monotonicIncreasing(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean monotonicDecreasing(ArrayList<Integer> list2) {
        for (int i = 0; i < list2.size() - 1; i++) {
            if (list2.get(i) < list2.get(+1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        System.out.println(monotonicIncreasing(list));
        list2.add(1);
        list2.add(2);
        list2.add(2);
        list2.add(3);
        System.out.println(monotonicDecreasing(list2));
    }
}
