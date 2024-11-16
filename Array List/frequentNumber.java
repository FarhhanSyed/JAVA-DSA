// For every unique integer target in nums, count the number of times target immediately follows
// an occurrence of key in nums.In other words,count the number of indices i such that:
// 0<=i<=nums.size()-2,nums.get(i)==key and,nums.get(i+1)==target.
// Return the target with the maximum count.

import java.util.ArrayList;
import java.util.HashMap;

public class frequentNumber {
    public static int frequent(ArrayList<Integer> list, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == key) {
                int target = list.get(i + 1);
                map.put(target, map.getOrDefault(target, 0) + 1);
            }
        }
        int maxCount = 0;
        int maxTarget = -1;
        for (int target : map.keySet()) {
            int count = map.get(target);
            if (count > maxCount) {
                maxCount = count;
                maxTarget = target;
            }
        }
        return maxTarget;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        System.out.println(list);
        System.out.println(frequent(list, 2));
    }
}
