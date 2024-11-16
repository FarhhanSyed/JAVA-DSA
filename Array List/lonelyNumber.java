import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class lonelyNumber {
    public static ArrayList findLonely(ArrayList<Integer> list) {
        Collections.sort(list);
        HashSet<Integer> set = new HashSet<>(list);
        ArrayList<Integer> ele = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            if (i < list.size() - 1 && list.get(i) == list.get(i + 1)) {
                continue;
            }
            if (!(set.contains(list.get(i) + 1)) && !(set.contains(list.get(i) - 1))) {
                ele.add(list.get(i));
            }
        }
        int lastElement = list.get(list.size() - 1);
        if (!(set.contains(lastElement - 1))) {
            ele.add(lastElement);
        }
        return ele;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(7);
        list.add(9);
        list.add(11);
        list.add(12);
        System.out.println(findLonely(list));
    }
}
