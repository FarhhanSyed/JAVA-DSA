
//Time Complexity-O(n)
//only for sorted array
import java.util.ArrayList;
import java.util.Arrays;

public class pairSumI {
    public static ArrayList<Integer> pairSum(ArrayList<Integer> list, int target) {
        int i = 0;
        int j = list.size() - 1;
        ArrayList<Integer> pair = new ArrayList<>();
        while (i != j) {
            if ((list.get(i) + list.get(j)) == target) {
                pair.add(list.get(i));
                pair.add(list.get(j));
                return pair;
            }
            if ((list.get(i) + list.get(j)) < target) {
                i++;
            } else {
                j--;
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int target = 5;
        System.out.println(pairSum(list, target));
    }
}

// Brute Force-O(n^2)
// public static ArrayList<Integer> pairSum(ArrayList<Integer> list, int target)
// {
// ArrayList<Integer> pairs = new ArrayList<>();
// for (int i = 0; i < list.size() - 1; i++) {
// for (int j = i + 1; j < list.size(); j++) {
// if ((list.get(i) + list.get(j)) == target) {
// pairs.add(list.get(i));
// pairs.add(list.get(j));
// return pairs;
// }
// }
// }
// return pairs;
// }
